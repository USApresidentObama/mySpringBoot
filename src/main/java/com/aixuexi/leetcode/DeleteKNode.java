package com.aixuexi.leetcode;

import com.aixuexi.model.ListNode;

/**
 * @Author liuao
 * @Date 2024/5/28 11:42
 * @Description
 **/
public class DeleteKNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int sum=0;
        while(node!=null) {
            sum++;
            node=node.next;
        }

        int i=sum-n+1;
        if (i==1) {
            head=head.next;
            return head;
        }
        ListNode node2 = head;
        ListNode pre = new ListNode(0, head);
        for(int j=1;j<=i;j++) {
            if (j==i) {
                ListNode next = node2.next;
                node2.next=null;
                pre.next=next;
                return head;
            }
            pre = pre.next;
            node2=node2.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        removeNthFromEnd(node1,2);
    }
}
