package com.aixuexi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author liuao
 * @Date 2024/5/15 17:31
 * @Description
 **/
public class FindRepeatString {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList();
        if (p==null || p=="" || s==null || s=="") {
            return list;
        }
        if (s.length()<p.length()) {
            return list;
        }

        int[] a = new int[26];
        int[] b = new int[26];

        for(int i=0;i<p.length();i++) {
            b[p.charAt(i)-'a']++;
            a[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(a,b)) {
            list.add(0);
        }
        for(int i=1;i<s.length()-p.length()+1;i++) {
            a[s.charAt(i-1)-'a']--;
            a[s.charAt(i+p.length()-1)-'a']++;
            if (Arrays.equals(a,b)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isEquals(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for(Map.Entry entry: map1.entrySet()) {
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i=0;i<s.length();i++) {
            Integer a = map.getOrDefault(s.charAt(i),0);
            ++a;
            map.put(s.charAt(i), a);
        }
        return map;
    }

    public static void main(String[] args) {
        findAnagrams("abab", "ab");
    }
}
