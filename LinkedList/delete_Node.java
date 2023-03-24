package com.company.Striver_SDE.LinkedList;

public class delete_Node {
    public static void main(String[] args) {

    }
    static void delete(int index, merge_two_lists.ListNode head1){
            merge_two_lists.ListNode temp=head1;
            int size=0;
            while(temp!=null){
                size++;
                temp=temp.next;
            }
            temp=head1;
            for(int i=0;i<size-index-1;i++){
                temp=temp.next;
            }
            if(temp.next==null){
                temp.next=null;
                return;
            }
            temp.next=temp.next.next;

    }
}
