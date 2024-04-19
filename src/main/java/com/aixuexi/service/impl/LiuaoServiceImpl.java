package com.aixuexi.service.impl;

import com.aixuexi.service.LiuaoService;
import org.springframework.stereotype.Service;


public class LiuaoServiceImpl implements LiuaoService {
    private static String CODE = "ok";

    @Override
    public void test(Integer a) {
        if (a == 1) {
            CODE = "no";
        }
        System.out.println(CODE);
    }
}
