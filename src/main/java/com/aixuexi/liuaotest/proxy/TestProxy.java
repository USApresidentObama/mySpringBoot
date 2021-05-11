package com.aixuexi.liuaotest.proxy;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        People people = new Teacher();
        People peopleProxy = (People) Proxy.newProxyInstance(People.class.getClassLoader(), people.getClass().getInterfaces(), new BlogProxy(people));
        peopleProxy.work();

    }
}
