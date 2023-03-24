package com.company.Striver_SDE.BInary_Tree_1;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class morris_inorder {
    public static void main(String[] args) {


    }
    static List<Integer> morrisInorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode nex=curr.left;
                while(nex.right!=null && nex.right!=curr){
                    nex=nex.right;
                }
                if(nex.right==null) {
                    nex.right = curr;
                    curr=curr.left;
                }
                else{
                    res.add(curr.val);
                    curr=curr.right;
                    nex.right=null;
                }
            }else{
                res.add(curr.val);
                curr=curr.right;
            }
        }
        return res;
    }
}
