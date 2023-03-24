package com.company.Striver_SDE.Binary_Tree_2;

import com.company.DoublyLinkedList;
import com.company.Striver_SDE.Recusrion.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class zig_zag {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);

        System.out.println(zigzagLevelOrder(root));

    }
    static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> qq = new LinkedList<>();
        qq.offer(root);
        boolean flag=true;
        while(!qq.isEmpty()){
            int size=qq.size();
            ArrayList<Integer> lis = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=qq.poll();
                if(temp.left!=null) qq.offer(temp.left);
                if(temp.right!=null) qq.offer(temp.right);
                if(flag) lis.add(temp.val);
                else lis.add(0,temp.val);
            }
            flag=!flag;
            res.add(lis);
        }
        return res;

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> dq = new ArrayDeque<>();
        boolean zig=true;
        while(!dq.isEmpty()){

        }
        return res;
    }
}
