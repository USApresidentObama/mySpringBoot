package com.aixuexi.util;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int a= BigDecimal.valueOf(1535)
                .divide(BigDecimal.valueOf(1000), 0, BigDecimal.ROUND_HALF_UP)
                .intValue();
        System.out.println(a);
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        System.out.println(DateTime.now().toString("yyyyMMdd HH:mm:ss"));

    }





}


