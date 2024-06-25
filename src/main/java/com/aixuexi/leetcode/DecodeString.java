package com.aixuexi.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @Author liuao
 * @Date 2024/5/30 11:35
 * @Description
 **/
public class DecodeString {
    static int index = 0;
    public static String decodeString(String s) {
        Stack<String> stack = new Stack();
        while(index<s.length()) {
            Character ch = s.charAt(index);
            if (Character.isLetter(ch) || ch.equals('[')) {
                stack.push(String.valueOf(ch));
                index++;
            }else if (Character.isDigit(ch)) {
                stack.push(getIntString(s));
            } else {
                boolean flag = true;
                StringBuilder build = new  StringBuilder();
                while(flag) {
                    String temp = stack.pop();
                    if (temp.equals("[")) {
                        flag = false;
                        int n = Integer.parseInt(stack.pop());
                        String a = build.reverse().toString();
                        while(n>0) {
                            pushString2Stack(a, stack);
                            n--;
                        }
                    } else{
                        build.append(temp);
                    }
                }
                index++;
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static String getIntString(String a) {
        StringBuilder build = new StringBuilder();
        while(Character.isDigit(a.charAt(index))) {
            build.append(a.charAt(index++));
        }
        return build.toString();
    }

    public static void pushString2Stack(String a, Stack<String> stack) {
        for(int i=0;i<a.length();i++) {
            stack.push(String.valueOf(a.charAt(i)));
        }
    }

    public static void main(String[] args) {
        decodeString("3[a]2[bc]");
        System.out.println(1);
    }
}
