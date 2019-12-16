package com.aixuexi;


import com.aixuexi.model.User;

import java.util.LinkedList;
import java.util.List;

public class Tets {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.equals(null));

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
