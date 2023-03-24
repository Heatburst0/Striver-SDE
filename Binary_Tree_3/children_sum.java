package com.company.Striver_SDE.Binary_Tree_3;

import com.company.Striver_SDE.Recusrion.TreeNode;

public class children_sum {
    public static void main(String[] args) {

    }
    static void convert(TreeNode root){
        if(root==null)
            return;
        int c=0;
        c+=root.left!=null ? root.left.val : 0;
        c+=root.right!=null ? root.right.val : 0;
        if(c< root.val){
            if(root.left!=null)
                root.left.val=root.val;
            if(root.right!=null)
                root.right.val=root.val;
        }
        convert(root.left);
        convert(root.right);
        c=0;
        c+=root.left!=null ? root.left.val : 0;
        c+=root.right!=null ? root.right.val : 0;
        if(root.right!=null || root.left!=null)
            root.val=c;
    }
}
