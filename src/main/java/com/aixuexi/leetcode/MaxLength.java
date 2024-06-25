package com.aixuexi.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author liuao
 * @Date 2024/5/13 11:15
 * @Description 无重复字符的最长子串
 **/
public class MaxLength {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int rigth=0;
        int maxLength = 0;
        for(int i=0;i<s.length();i++) {
            if(i!=0) {
                set.remove(s.charAt(i-1));
            }
            while(rigth<s.length()&&!set.contains(s.charAt(rigth))) {
                set.add(s.charAt(rigth));
                rigth++;
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap();
        List<String> a = Lists.newArrayList("1","2");
        List<String> b = Lists.newArrayList("3","4");
        map.put("a",a);
        map.put("b",b);
        List<String> lis = new ArrayList(map.values());
        System.out.println(lis);
        String s1 = "a";
        String s2 = "b";
        String s3 = String.format("params:{} ",s1);
        System.out.println(s3);
    }
}
