package com.aixuexi.util;

public class Consumer extends Thread {
    private Gun gun;

    public Consumer(Gun gun) {
        this.gun = gun;
    }

    public void run() {
        try {
            gun.shoot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
