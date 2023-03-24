package com.company.Striver_SDE.LinkedList;

public class delete_given_node {
    public static void main(String[] args) {

    }
    static void delete(merge_two_lists.ListNode node){

            node.val=node.next.val;
            node.next=node.next.next;

    }
}
