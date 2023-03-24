package com.company.Striver_SDE.BInary_Tree_1;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class bottom_top_view {
    public static void main(String[] args) {

    }
    private static class pair{
        TreeNode node;
        int hd;
        public pair(TreeNode node,int hd){
            this.node
                    =node;
            this.hd=hd;
        }
    }
    static ArrayList<Integer> bottom(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<pair> qq = new LinkedList<>();
        qq.add(new pair(root,0));
        TreeMap<Integer,Integer> mp= new TreeMap<>();
        while(!qq.isEmpty()){
            pair obj = qq.poll();
            mp.put(obj.hd,obj.node.val);
            if(obj.node.left!=null)
                qq.add(new pair(obj.node.left,obj.hd-1));
            if(obj.node.right!=null)
                qq.add(new pair(obj.node.right,obj.hd+1));
        }
        res.addAll(mp.values());
        return res;
    }
    static ArrayList<Integer> top(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<pair> qq = new LinkedList<>();
        qq.add(new pair(root,0));
        TreeMap<Integer,Integer> mp= new TreeMap<>();
        while(!qq.isEmpty()){
            pair obj = qq.poll();
            if(!mp.containsKey(obj.hd)){
                mp.put(obj.hd,obj.node.val);
            }
            if(obj.node.left!=null)
                qq.add(new pair(obj.node.left,obj.hd-1));
            if(obj.node.right!=null)
                qq.add(new pair(obj.node.right,obj.hd+1));
        }
        res.addAll(mp.values());
        return res;
    }
}
