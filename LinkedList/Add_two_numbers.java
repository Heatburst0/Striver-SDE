package com.company.Striver_SDE.LinkedList;

public class Add_two_numbers {
    static ListNode l1;
    static ListNode l2;
    public static void main(String[] args) {

    }
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
    static ListNode addTwo(){
        ListNode head1=l1;
        ListNode head2=l2;
        ListNode temp = new ListNode();
        ListNode tail=temp;
        int carry=0;
        while(head1!=null || head2!=null){
            int x=0;
            if(head1!=null){
                x+=head1.val;
                head1=head1.next;
            }
            if(head2!=null){
                x+=head2.val;
                head2=head2.next;
            }
            int sum=carry+x;
            carry=sum/10;
            sum=sum%10;
            tail.next=new ListNode(sum);
            tail=tail.next;

        }
        if(carry>0){
            tail.next=new ListNode(carry);
        }
        return temp.next;
    }
}
