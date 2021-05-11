package com.aixuexi.liuaotest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BlogProxy implements InvocationHandler {

    private Object object;

    public BlogProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法前打印日志");
        method.invoke(object, args);
        System.out.println("方法后打印日志");
        return null;
    }
}
