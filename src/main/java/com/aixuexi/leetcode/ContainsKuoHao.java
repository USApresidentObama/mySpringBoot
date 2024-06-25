package com.aixuexi.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author liuao
 * @Date 2024/5/20 14:31
 * @Description
 **/
public class ContainsKuoHao {

    public static boolean isValid(String s) {
        if (s=="") {
            return false;
        }
        int n = s.length();
        if (n%2!=0) {
            return false;
        }
        Map<Character,Character> map = new HashMap();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack();
        for(int i=0;i<n;i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()|| !map.get(s.charAt(i)).equals(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid("()");
    }
}
