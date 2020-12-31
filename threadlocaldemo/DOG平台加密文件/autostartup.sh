#!/bin/bash
export JAVA_HOME=/usr/java/jdk1.8
export PATH=$JAVA_HOME/bin:$PATH
/home/software/redis-3.2.1/src/redis-server /home/software/redis-3.2.1/redis.conf
sleep 5
nohup /home/software/java/consul agent -dev 1>/home/software/java/logs/consul.log 2>&1 &
sleep 5
nohup java -jar /home/software/java/fw_service-1.0-SNAPSHOT.jar 1>/home/software/java/logs/fw_service.log 2>&1 &
chmod 777 /home/software/java/logs/fw_service.log
