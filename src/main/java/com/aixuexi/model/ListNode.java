package com.aixuexi.model;

/**
 * @Author liuao
 * @Date 2024/5/7 14:32
 * @Description
 **/
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
