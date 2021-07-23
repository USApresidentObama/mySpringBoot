package com.aixuexi.util;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ExecutionException;

import com.aixuexi.model.User;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;

public class Test {

    public static void main(String[] args) {
//        User user = new User();
//        user.setId(1l);
//        Long id = user.getId();
//        user.setId(null);
//        System.out.println(id);
//        System.out.println(user);

    }


    public static void bublle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j+1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static int binaryWithDiGui(int low, int high, int[] arr, int target) {
        if (target < arr[low] || target > arr[high] || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (target < arr[mid]) {
            return binaryWithDiGui(low, mid-1, arr, target);
        }
        if (arr[mid] < target) {
            return binaryWithDiGui(mid+1, high, arr, target);
        }
        return mid;
    }

    public static int binaryWithOutDiGui(int low, int high, int[] arr, int target) {
        if (target < arr[low] || target > arr[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int mid = (left + right)/2;
        swap(mid, left, arr);
        int index = arr[left];
        int low = left;
        int high = right;

        while (low < high) {
            while (low < high && index <= arr[high]) {
                high --;
            }
            swap(low, high, arr);
            while (low < high && index >= arr[low]) {
                low ++;
            }
            swap(low, high, arr);
        }
        if (left < low) {
            quickSort(arr, left, low - 1);
        }
        if (right > low) {
            quickSort(arr, low + 1, right);
        }
    }

    public static void quickSortWithStack(int[] arr, int left, int right) {
        Stack<Map<String, Integer>> stack = new Stack<>();

        Map<String, Integer> map = new HashMap<>();
        map.put("low", left);
        map.put("high", right);
        stack.push(map);

        while (!stack.isEmpty()) {
            Map<String, Integer> tempMap = stack.pop();
            int low = tempMap.get("low");
            int high = tempMap.get("high");
            int tempLow = low;
            int tempHigh = high;

            int index = arr[low];
            while (low < high) {
                while (low < high && index <= arr[high]) {
                    high--;
                }
                swap(low, high, arr);
                while (low < high && index >= arr[low]) {
                    low++;
                }
                swap(low, high, arr);
            }
            if (tempLow < low) {
                Map<String, Integer> map1 = new HashMap<>();
                map1.put("low", left);
                map1.put("high", low - 1);
                stack.push(map1);
            }
            if (tempHigh > low) {
                Map<String, Integer> map2 = new HashMap<>();
                map2.put("low", low + 1);
                map2.put("high", right);
                stack.push(map2);
            }
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }







}


