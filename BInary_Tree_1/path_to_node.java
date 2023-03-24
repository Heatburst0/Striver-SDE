package com.company.Striver_SDE.BInary_Tree_1;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.ArrayList;

public class path_to_node {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> res;
    static ArrayList<Integer> find(TreeNode root, int target){
        res=new ArrayList();
        ArrayList<Integer> lis= new ArrayList<>();
        lis.add(root.val);
        helper(root,lis,target);
        return res;
    }
    static void helper(TreeNode root,ArrayList<Integer> lis,int target) {
        if (root == null)
            return;
        if (root.val == target)
            res.addAll(new ArrayList<>(lis));
        if (root.left != null) {
            lis.add(root.left.val);
            helper(root.left, lis, target);
            lis.remove(lis.size() - 1);
        }
        if (root.right != null) {
            lis.add(root.right.val);
            helper(root.right, lis, target);
            lis.remove(lis.size() - 1);
        }
    }
}
