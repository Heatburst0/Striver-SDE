package com.company.Striver_SDE.LinkedList;

import java.util.*;

public class merge_two_lists {
    static ListNode head1=null;
    static ListNode head2=null;
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
    public static void main(String[] args) {
//        adder(true,9);
//        adder(true,8);
//        adder(true,7);
//        adder(true,6);
//        adder(true,5);
        adder(true,1);
        adder(true,2);
        adder(true,2);
        adder(true,1);
        System.out.println(pallindrome());
        ArrayList<Integer> lis= new ArrayList<>();
        lis.add(1);
        lis.add(4);
        lis.add(3);
        lis.add(2);
        lis.add(0);
        Object[] arr=lis.toArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int a= (int) arr[0];

    }
    static ListNode merge(ListNode head1,ListNode head2){
        ListNode l1=null;
        ListNode l2=null;
        ListNode res=null;
        if(head1.val<head2.val){
            res=l1=head1;
            l2=head2;
        }else{
            res=l1=head2;
            l2=head1;
        }
        while(l1!=null){
            ListNode temp=l1;
            while(l1!=null && l1.val<=l2.val){
                temp=l1;
                l1=l1.next;
            }
            temp.next=l2;
            if(l1!=null && l1.val>l2.val){
                ListNode temp2=l1;
                l1=l2;
                l2=temp2;
            }
        }
        return res;
    }
    static void display(ListNode Head){
        ListNode temp=Head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
    static void adder(boolean check,int val ){
        ListNode temp = new ListNode(val);
        if(check){
            if(head1==null){
                head1=temp;
                return;
            }
            temp.next=head1;
            head1=temp;
        }else{
            if(head2==null){
                head2=temp;
                return;
            }
            temp.next=head2;
            head2=temp;
        }

    }

    static  void dle(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;
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

    static boolean check(){
        ListNode temp1=head1;
        while(temp1!=null){
            if(temp1.val==Integer.MAX_VALUE)
                return true;
            temp1.val=Integer.MAX_VALUE;
            temp1=temp1.next;
        }
        return false;
    }
    static void reverseGroups(int n){
        ListNode pre=new ListNode();
        ListNode temp=head1;
        ListNode newHead=head1;
        ListNode prev=new ListNode();
        ListNode ekOr = new ListNode();
        pre.next=head1;
        for(int i=1;i<n;i++)
            newHead=newHead.next;
        ekOr=temp;
        while(temp!=null){
            for(int i=1;i<n;i++){
                if(temp==null){
                    prev.next=ekOr;
                    return;
                }
                temp=temp.next;
            }
            if(temp==null)
                break;
            ListNode node =temp.next;
            prev.next=temp;
            temp=node;
            ListNode current=ekOr;
            prev=current;
            ListNode next=current.next;
            for(int i=0;i<n;i++){
                current.next=pre;
                pre=current;
                current=next;
                if(next==null){
                    prev.next=null;
                    return;
                }
                next=next.next;
            }
            ekOr=temp;
            pre=prev;
        }
        prev.next=ekOr;
    }
    static void reverse(int k){
        ListNode dummy = new ListNode();
        dummy.next=head1;
        ListNode current=dummy.next;
        ListNode pre=dummy;
        ListNode nex=current.next;
        int length=0;
        ListNode temp=head1;
        while(temp!=null){
            temp=temp.next;length++;
        }
        while(length>=k){
            current=pre.next;
            nex=current.next;
            for(int i=1;i<k;i++){
                current.next=nex.next;
                nex.next=pre.next;
                pre.next=nex;
                nex=current.next;
            }
            length-=k;
            pre=current;
        }

    }
    static boolean pallindrome(){
        ListNode fast=head1;
        ListNode slow=head1;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //now reverse
        ListNode pre=null;
        ListNode current=slow.next;
        ListNode nex=current.next;
        while(nex!=null){
            current.next=pre;
            pre=current;
            current=nex;
            nex=nex.next;
        }
        current.next=pre;
        slow.next=current;
        ListNode node=head1;
        slow=slow.next;
        while(slow!=null){
            if(node.val!=slow.val)
                return false;
            node=node.next;
            slow=slow.next;
        }
        return true;
    }
    static ListNode point(){
        ListNode fast = head1;
        ListNode slow=head1;
        ListNode en=head1;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                while(slow!=en){
                    slow=slow.next;
                    en=en.next;
                }
                return slow;
            }
        }
        return null;
    }
}
