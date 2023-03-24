package com.company.Striver_SDE.stack_ques_2;

import java.util.HashMap;

public class LeastFrequentlyUsed {
    HashMap<Integer,Node> cache;
    HashMap<Integer,dll> fr;
    int max,freq,size;
    public LeastFrequentlyUsed(int capacity) {
        max=capacity;
        cache=new HashMap<>();
        fr=new HashMap<>();
        freq=1;
        size=0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        else update(node);
        return node.val;

    }

    public void put(int key, int value) {
        if(size==0) return;
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            node.val=value;
            update(node);

        }else{
            Node node=new Node(key,value);
            cache.put(key,node);
            if(size==max){
                dll lis=fr.get(freq);
                cache.remove(lis.removeLast().key);
                size--;
            }
            freq=1;
            dll lis=fr.getOrDefault(node.cnt,new dll());
            lis.insert(node);
            fr.put(node.cnt,lis);
            size++;

        }

    }
    public void update(Node node){
        dll old=fr.get(node.cnt);
        old.remove(node);
        if(node.cnt==freq && old.size==0) freq++;
        node.cnt++;
        dll newl=fr.getOrDefault(node.cnt,new dll());
        newl.insert(node);
        fr.put(node.cnt,newl);

    }
    class Node{
        Node prev,next;
        int key,val;
        int cnt;
        public Node(int key,int value){
            this.key=key;
            this.val=value;
            this.cnt=1;
            this.prev=null;
            this.next=null;
        }
    }
    class dll{
        Node head;
        Node tail;
        int size;
        public dll(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        public void insert(Node node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
            size++;
        }
        public void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        public Node removeLast(){
            if(size>0){
                Node node=tail.prev;
                remove(tail.prev);
                return node;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        LeastFrequentlyUsed lf = new LeastFrequentlyUsed(0);




    }

}

