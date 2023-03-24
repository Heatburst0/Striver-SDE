package com.company.Striver_SDE.LinkedList;

public class Reverse_List {
    private static ListNode head;
    public static void main(String[] args) {

    }
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
    static ListNode reverse(){
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    static ListNode recursiveReverse(ListNode head){
        if(head== null || head.next==null){
            return head;
        }
       ListNode temp = recursiveReverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
    static ListNode reverseingroup(ListNode head,int k){
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        ListNode dum = new ListNode();
        dum.next=head;
        ListNode pre=dum;
        while(len<=k){
            ListNode curr=pre.next;
            ListNode nex= curr.next;
            for(int i=0;i<k;i++){
                curr.next=nex.next;
                nex.next=pre.next;
                pre.next=nex;
                nex=curr.next;
            }
            pre=curr;
        }
        return dum.next;
    }
}
