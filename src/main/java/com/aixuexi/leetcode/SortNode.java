package com.aixuexi.leetcode;

import com.aixuexi.model.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author liuao
 * @Date 2024/5/7 14:34
 * @Description
 **/
public class SortNode {



    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList();
        while(head !=null) {
            list.add(head.val);
        }
        Collections.sort(list);
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        for(Integer val: list) {
            ListNode tempNode = new ListNode(val);
            node.next = tempNode;
            node = tempNode;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node =sortList(node1);
        System.out.println(1);

    }
}
