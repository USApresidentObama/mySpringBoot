package com.aixuexi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author liuao
 * @Date 2024/5/31 16:56
 * @Description
 **/
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3) {
            return null;
        }
        Arrays.sort(nums);
        Set<String> set =new HashSet();
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        for(int i=0;i<nums.length;i++) {
            if (nums[i]>0) {
                break;
            }
            if (i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            for(int j=i+1;j<nums.length;j++) {
                if (j>i+1&&nums[j]==nums[j-1]) {
                    continue;
                }
                int k = n-1;
                while(k>j) {
                    if (k<n-1&&nums[k]==nums[k+1]) {
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k]==0) {
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                        result.add(list);
                        break;
                    }
                    k--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-1,0,1,2,-1,-4};
        int n = 1;
        while (n<4) {
            if (n==2) {
                n++;
                continue;
            }
            System.out.println(n);
            n++;
        }
    }
}
