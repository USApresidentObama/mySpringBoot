package com.aixuexi.util;

import java.util.*;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Gun gun  = new Gun();
        Consumer consumer = new Consumer(gun);
        Producer producer = new Producer(gun);

        consumer.start();
        Thread.sleep(300);
        producer.start();

    }





}


