package com.aixuexi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author liuao
 * @Date 2024/5/9 11:39
 * @Description
 **/
public class TestLeetCode {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(nums);
        Set<Character> set = new HashSet();
        "1".charAt(1);
    }

    public static void moveZeroes(int[] nums) {
        int index = nums.length-1;
        for(int i=0;i<=index;i++) {
            if (nums[i]!=0) {
                continue;
            }

            for(int j=i;j<index;j++){
                int a=j;
                while(a<index&&nums[a+1] == 0) {
                    a = a+2;
                }
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
            index--;
        }
    }
}