package com.company.Striver_SDE.LinkedList;

public class middle_of_list {
    static ListNode head;
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
            this.next=null;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
    //naive
    static ListNode middle(){
        ListNode temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        for(int i=0;i<count/2;i++){
            head=head.next;
        }
        return head;
    }
    //optimal
    static ListNode middle2(){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
