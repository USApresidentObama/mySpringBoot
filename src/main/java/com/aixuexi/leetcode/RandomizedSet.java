package com.aixuexi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author liuao
 * @Date 2024/6/5 16:04
 * @Description
 **/
public class RandomizedSet {
    List<Integer> list;

    public RandomizedSet() {
        list = new ArrayList();
    }

    public boolean insert(int val) {
        boolean flag = list.add(val);
        return flag;
    }

    public boolean remove(int val) {
        boolean flag = list.remove(Integer.valueOf(val));
        return flag;
    }

    public int getRandom() {
        Random random = new Random();
        int n = random.nextInt(list.size()-1);
        int a = list.get(n);
        return a;

    }
}
