package com.cg.controller;

public class Val<T> {
    T v;
    public void set(T _v){
        v = _v;
    }
    public T get(){
        return v;
    }
}
