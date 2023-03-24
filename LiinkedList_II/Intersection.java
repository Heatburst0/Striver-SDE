package com.company.Striver_SDE.LiinkedList_II;

import com.company.Striver_SDE.LinkedList.merge_two_lists;

import java.util.HashMap;

public class Intersection {
    static ListNode head1;
    static ListNode head2;
    public static void main(String[] args) {

    }
    static Object intersection(){
        HashMap<ListNode,Integer> hm = new HashMap<>();
        ListNode temp1=head1;
        while(temp1!=null){
            hm.put(temp1,temp1.val);
            temp1=temp1.next;
        }
        ListNode temp2=head2;
        while (temp2!=null){
            if(hm.containsKey(temp2)){
                return temp2;
            }
            temp2=temp2.next;
        }
        return null;

    }
    static ListNode intersection2(){
        ListNode temp1=head1;
        ListNode temp2=head2;
        int size1=0;
        int size2=0;
        while(temp1!=null){
            size1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            size2++;
            temp2=temp2.next;
        }
        int difference=size1-size2;
        if(difference>0){
            while(difference--!=0)
                head1=head1.next;
        }else{
            while(difference++!=0)
                head2=head2.next;
        }
        while(head1!=null){
            if(head1==head2){
                return head1;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
    }
    static ListNode intersection3(){
        ListNode d1=head1;
        ListNode d2=head2;
        while(d1!=d2) {
            if (d1 == null){
                d1 = head2;
                d2 = d2.next;
                continue;
            }
            if(d2==null){
                d2=head1;
                d1=d1.next;
                continue;
            }
            d1=d1.next;
            d2=d2.next;
        }
        return d1;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
        this.next=null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
