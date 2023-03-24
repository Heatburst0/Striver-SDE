package com.company.Striver_SDE.Binary_Tree_3;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class isSymmetric {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        System.out.println(l.toString());
        TreeNode root = new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(3);
        root.left=new TreeNode(2);
        root.left.right=new TreeNode(3);
        System.out.println(isSame(root));
    }
    static boolean isSame(TreeNode root){
        if(root==null)
            return true;
        String l=leftSide(root.left).toString();
        String r=rightSide(root.right).toString();
        return l.equals(r);
    }
    static List<Integer> rightSide(TreeNode root){
        List<Integer> lis = new ArrayList<>();
        if(root==null)
            return lis;
        Queue<TreeNode> qq = new LinkedList<>();
        qq.offer(root);
        while(!qq.isEmpty()){
            TreeNode temp =qq.poll();
            int val= temp!=null ? temp.val : Integer.MAX_VALUE;
            lis.add(val);
            if(temp!=null){
                if(temp.right!=null){
                    qq.add(temp.right);
                }else
                    lis.add(Integer.MAX_VALUE);
                if(temp.left!=null){
                    qq.add(temp.left);
                }else
                    qq.add(null);
            }
        }
        return lis;
    }
    static List<Integer> leftSide(TreeNode root){
        List<Integer> lis = new ArrayList<>();
        if(root==null)
            return lis;
        Queue<TreeNode> qq = new LinkedList<>();
        qq.offer(root);
        while(!qq.isEmpty()){
            TreeNode temp =qq.poll();
            int val= temp!=null ? temp.val : Integer.MAX_VALUE;
            lis.add(val);
            if(temp!=null){
                if(temp.left!=null){
                    qq.add(temp.left);
                }else
                    lis.add(Integer.MAX_VALUE);
                if(temp.right!=null){
                    qq.add(temp.right);
                }else
                    qq.add(
                            null
                    );
            }
        }
        return lis;
    }
    static boolean check(TreeNode root1,TreeNode root2){
        if(root1==null || root2==null)
            return root1==root2;
        return (root1.val==root2.val) && (check(root1.left,root2.right) && check(root1.right,root2.left));
    }
}
