package com.company.Striver_SDE.Binary_Tree_3;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.HashMap;

public class construct_Tree_in_pre {
    public static void main(String[] args) {

    }
    static TreeNode construct(int[] pre, int[] in){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<pre.length;i++){
            hm.put(in[i],i);
        }
        TreeNode root=build(hm,pre,in,0,pre.length-1,0,in.length-1);
        return root;
    }

    private static TreeNode build(HashMap<Integer, Integer> hm, int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(pre[preStart]);
        int ind=hm.get(pre[preStart]);
        int indleft=ind-inStart;
        root.left=build(hm,pre,in,preStart+1,preStart+indleft,inStart,ind-1);
        root.right=build(hm,pre,in,preStart+indleft+1,preEnd,ind+1,inEnd);
        return root;
    }
}
