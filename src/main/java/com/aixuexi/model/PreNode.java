package com.aixuexi.model;

/**
 * @Author liuao
 * @Date 2024/5/8 10:55
 * @Description
 **/
public class PreNode {

    public int val;
    public PreNode next;
    public PreNode pre;
    PreNode() {}
    public PreNode(int val) { this.val = val; }
    public PreNode(int val, PreNode next, PreNode pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}
