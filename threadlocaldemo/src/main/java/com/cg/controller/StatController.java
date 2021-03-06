package com.cg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class StatController {
    static HashSet<Val<Integer>> set = new HashSet<>();
    synchronized static void _addSet(Val<Integer> v){
        set.add(v);
    }
    static ThreadLocal<Val<Integer>> c = new ThreadLocal<Val<Integer>>(){
        @Override
        protected Val<Integer> initialValue(){
            Val<Integer> v = new Val<>();
            v.set(0);
            _addSet(v);
            return v;
        }
    };

    void _add() throws InterruptedException {
        Thread.sleep(100);
        Val<Integer> v = c.get();
        v.set(v.get()+1);
    }
    @RequestMapping("/stat")
    public Integer stat(){
        return set.stream().map(x -> x.get()).reduce((a,x) -> a+x).get();
    }

    @RequestMapping("/add")
    public Integer add() throws InterruptedException {
       _add();
        return 1;
    }

}
