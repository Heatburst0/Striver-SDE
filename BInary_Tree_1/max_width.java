package com.company.Striver_SDE.BInary_Tree_1;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.*;

public class max_width {
    static int min;
    static boolean flag=false;
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        System.out.println(maxWidth(root));

    }
    static int maxWidth(TreeNode root){
        int max=0;
        if(root==null)
            return 0;
        Queue<pair> qq = new LinkedList<>();
        qq.offer(new pair(root,0));
        while(!qq.isEmpty()){
            int leg=qq.size();
            int min=qq.peek().l;
            int f=0,l=0;
            for(int i=0;i<leg;i++){
                pair ref=qq.poll();
                int curr=ref.l-min;
                if(i==0)
                    f=curr;
                if(i==leg-1)
                    l=curr;
                if(ref.node.left!=null)
                    qq.offer(new pair(ref.node,2*curr+1));
                if(ref.node.right!=null)
                    qq.offer(new pair(ref.node,2*curr+2));
            }
            max=Math.max(max,l-f+1);

        }
        return max;
    }
    private static class pair{
        TreeNode node;
        int l;
        pair(TreeNode root,int l){
            this.node=root;
            this.l=l;
        }
    }
}
