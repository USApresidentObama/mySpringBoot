package com.aixuexi.liuaotest.proxy;

public class Teacher implements People {
    @Override
    public void work() {
        System.out.println("work hard");
        eat();
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}
