package com.company.Striver_SDE.BInary_Tree_1;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class morris_preorder {
    public static void main(String[] args) {

    }
    static List<Integer> morrisPreorder(TreeNode root){
        List<Integer> res  = new ArrayList<>();
        if(root==null)
            return res;
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left!=null){
                res.add(curr.val);
                TreeNode nexl=curr.left;
                while(nexl.right!=null && nexl.right!=curr)
                    nexl=nexl.right;
                if(nexl.right==null){
                    nexl.right=curr.right;
                    curr=curr.left;
                }
            }else{
                res.add(curr.val);
                curr=curr.right;
            }
        }
        return res;
    }
}
