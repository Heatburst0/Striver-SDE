package com.company.Striver_SDE.stack_ques_2;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class lru_cache {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(1,2);
        int x= hm.get(2)!=null ? hm.get(2) : 0;
        System.out.println(x);
        Queue<Integer> qq = new ArrayDeque<>();
        qq.offer(1);
        qq.offer(2);
        System.out.println(qq.remove(7));


    }
    HashMap<Integer,Dlist> lru;
    Dlist head = new Dlist(0,0);
    Dlist tail = new Dlist(0,0);
    int max;
    public lru_cache(int capacity) {
        lru=new HashMap<>();
        max=capacity;
        max=capacity-1;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(lru.containsKey(key)){
            Dlist x=lru.get(key);
            remove(x);
            insert(x.val,key);
            return x.val;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(lru.containsKey(key)){
            remove(lru.get(key));
        }
        if(lru.size()==max){
            remove(tail.prev);
        }
        insert(value,key);
    }
    class Dlist{
        int val;
        int key;
        Dlist next;
        Dlist prev;
        Dlist(int value,int key){
            this.key=key;
            this.val=value;
            this.prev=null;
            this.next=null;
        }
    }
    public void insert(int val,int key){
        Dlist node = new Dlist(val,key);
        lru.put(key,node);
        node.prev=head;
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
    }
    public void remove(Dlist node){
        lru.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}
