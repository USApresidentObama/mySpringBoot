package com.aixuexi;


import com.aixuexi.model.User;
import com.aixuexi.util.DesUtil;
import com.liepin.cetus.util.base.BigIntegerUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Tets {
    public static void main(String[] args) throws InterruptedException {
    }


    public static void sort(int[] a) {
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = 0; j <a.length-i-1 ; j++) {
                if(a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
