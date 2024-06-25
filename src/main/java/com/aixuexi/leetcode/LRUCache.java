package com.aixuexi.leetcode;

import com.aixuexi.model.PreNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liuao
 * @Date 2024/5/8 10:56
 * @Description
 **/
public class LRUCache {

    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map = new HashMap();

    class Node{
        int key;
        int val;
        Node next;
        Node pre;
        Node(){};
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre =head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        deleteFromNode(node);
        move2Head(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            deleteFromNode(node);
            move2Head(node);
            return;
        }
        if (capacity == map.size()) {
            Node deleteNode = tail.pre;
            deleteFromNode(deleteNode);
            int delKey = deleteNode.key;
            map.remove(delKey);
        }
        Node newNode = new Node(key,value);
        move2Head(newNode);
        map.put(key, newNode);
    }

    public void deleteFromNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void move2Head(Node node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    public void move2Tail(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre =node;
    }

}
