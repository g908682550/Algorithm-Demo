package code_test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Resource{
    ReentrantLock lock1=new ReentrantLock();
    ReentrantLock lock2=new ReentrantLock();
    public void incr(){
        try{
            lock1.lock();
            try{TimeUnit.SECONDS.sleep(3);} catch(InterruptedException e){e.printStackTrace();}
            decr();
        }finally {
            lock1.unlock();
        }

    }

    public void decr(){
        try{
            lock2.lock();
            try{TimeUnit.SECONDS.sleep(4);} catch(InterruptedException e){e.printStackTrace();}
            incr();
        }
        finally {
            lock2.unlock();
        }
    }
}

public class A {
    public static void main(String[] args) {
        Resource resource=new Resource();
        new Thread(()->{
           resource.incr();
        }).start();
        new Thread(()->{
            resource.decr();
        }).start();
    }
}
