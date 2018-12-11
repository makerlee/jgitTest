package com.example.demo.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("child thread start park....");
            LockSupport.park();
            System.out.println("child thread end park");
        });
        t1.start();

        Thread.sleep(1000);

        System.out.println("main thread unpark t1");
        LockSupport.unpark(t1);
    }
}
