package com.aixuexi.util;

public class Gun {

    public int size = 20;


    public synchronized void shoot() throws InterruptedException {
//        while (true) {
//            if (size <= 0) {
//                this.wait();
//            } else {
//                size--;
//                Thread.sleep(300);
//                System.out.println("发射piupiu，子弹剩余量:" + size);
//                this.notify();
//            }
//        }
        Thread.sleep(3000);
        System.out.println("shoot");
    }

    public  void reload() throws InterruptedException {
//        while (true) {
//            if (size > 0) {
//                this.wait();
//            } else {
//                size = 20;
//                System.out.println("重新装弹完成，子弹数量：" + size);
//                this.notify();
//            }
//        }
        System.out.println("reload");
    }
}
