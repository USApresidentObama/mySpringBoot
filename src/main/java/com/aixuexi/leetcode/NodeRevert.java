package com.aixuexi.leetcode;

import com.aixuexi.model.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liuao
 * @Date 2024/5/14 11:51
 * @Description
 **/
public class NodeRevert {

    public void revert(ListNode node) {
        ListNode pre = null;
        while (node!=null) {
            ListNode tempNode = node.next;
            node.next = pre;
            pre = node;
            node = tempNode;
        }
    }

    public boolean isEquals(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for(Map.Entry entry: map1.entrySet()) {
            if (entry.getValue()!=map2.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }
}
