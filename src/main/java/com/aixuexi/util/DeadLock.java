package com.aixuexi.util;

public class DeadLock {

    public static Object money = new Object();
    public static Object goods = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (money) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (goods) {

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (goods) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (money) {

                }
            }
        }).start();

    }
}
