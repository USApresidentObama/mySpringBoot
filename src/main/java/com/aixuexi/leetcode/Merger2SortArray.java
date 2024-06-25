package com.aixuexi.leetcode;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

/**
 * @Author liuao
 * @Date 2024/5/28 15:07
 * @Description
 **/
public class Merger2SortArray {

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length+b.length];
        int aIndex =0;
        int bIndex = 0;
        int i = 0;
        while(aIndex<a.length || bIndex<b.length) {
            if (bIndex == b.length) {
                result[i] = a[aIndex++];
            } else if (aIndex == a.length) {
                result[i] = b[bIndex++];
            } else if (a[aIndex]<=b[bIndex]) {
                result[i] = a[aIndex++];
            } else  {
                result[i] = b[bIndex++];
            }
            i++;
        }
        return result;
    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int index1=0;
        int index2=0;
        int[] arr = new int[m+n];
        int index = 0;
        while(index1<m&&index2<n) {
            if (nums1[index1]<=nums2[index2]) {
                arr[index]=nums1[index1];
                index1++;
            } else{
                arr[index]=nums2[index2];
                index2++;
            }
            index++;
        }
        if (index1==m) {
            for (int j = index2; j < n; j++) {
                int c =  nums2[j];
                arr[index] = c;
                index++;
            }
        }
        if (index2==n) {
            for (int j = index1; j < n; j++) {
                arr[index] = nums1[j];
                index++;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {2,5,6};
        int[] c = merge(a, b);
        int[] result= merge2(a, 3,b,3);
        System.out.println(a[-1]);

    }
}
