package com.aixuexi;

import com.aixuexi.util.Consumer;
import com.aixuexi.util.Gun;
import com.aixuexi.util.Producer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDeadLock {
    private static Object goods = new Object();
    private static Object money = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Lock1());
        Thread thread2 = new Thread(new Lock2());
        thread1.start();
        thread2.start();


    }

    static class Lock1 implements Runnable {
        @Override
        public void run() {
            System.out.println("lock1 start");
            synchronized (goods) {
                System.out.println("锁住了商品");
                try {
                    Thread.sleep(3000);
                    synchronized (money) {
                        System.out.println("lock1 锁住了商品和钱");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Lock2 implements Runnable {
        @Override
        public void run() {
            System.out.println("lock2 start");
            synchronized (money) {
                System.out.println("lock2锁住了钱需要商品");
                try {
                    Thread.sleep(3000);
                    synchronized (goods) {
                        System.out.println("lock2 锁住了商品和钱");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
