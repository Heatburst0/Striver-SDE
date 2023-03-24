package com.company.Striver_SDE.Binary_Tree_2;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Border_Traversal {
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static void main(String[] args) {


    }
    static ArrayList<Integer> traverse(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(isleaf(root))
            res.add(root.val);
        leaftraverse(root,res);
        lefttraverse(root.left,res);
        righttraverse(root.right,res);
        return res;

    }

    private static void leaftraverse(TreeNode root, ArrayList<Integer> res) {
        if(isleaf(root)){
            res.add(root.val);
            return;
        }
        if(root.left!=null)
            leaftraverse(root.left,res);
        if(root.right!=null)
            leaftraverse(root.right,res);
    }

    private static void righttraverse(TreeNode root, ArrayList<Integer> res) {
        TreeNode temp=root;
        LinkedList<Integer> lis = new LinkedList<>();
        while(temp!=null){
            if(!isleaf(temp))
                lis.addFirst(temp.val);
            if(temp.right!=null) temp=temp.right;
            else temp=temp.left;
        }
        res.addAll(lis);
    }

    static void lefttraverse(TreeNode root,ArrayList<Integer> res){
        TreeNode temp=root;
        while(temp!=null){
            if(!isleaf(temp))
                res.add(temp.val);
            if(temp.left!=null) temp=temp.left;
            else temp=temp.right;
        }
    }
    static boolean isleaf(TreeNode root){
        if(root.left!=null || root.right!=null)
            return false;
        return true;
    }
}
