package com.aixuexi.util;

public class Producer extends Thread {

    private Gun gun;

    public Producer(Gun gun) {
        this.gun = gun;
    }

    public void run() {
        try {
            gun.reload();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
