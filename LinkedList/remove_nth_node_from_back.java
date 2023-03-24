package com.company.Striver_SDE.LinkedList;

public class remove_nth_node_from_back {
    static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
            this.next=null;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static void remove(int n){
        ListNode start=new ListNode();
        ListNode p1=start;
        ListNode p2=start;
        for(int i=1;i<=n;i++){
            p1=p1.next;
        }
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p2=p2.next.next;
    }

}

