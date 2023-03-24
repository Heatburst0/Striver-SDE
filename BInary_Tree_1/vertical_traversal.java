package com.company.Striver_SDE.BInary_Tree_1;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.*;

public class vertical_traversal {
    static TreeNode root;
    public static void main(String[] args) {
//        List<List<Integer>> r = new ArrayList<>();
//        r.add(Arrays.asList(3,2,2));
//        r.add(Arrays.asList(3));
//        r.add(Arrays.asList(0));
//        for(List<Integer> it : r){
//            Collections.sort(it);
//        }
//        System.out.println(r);
        root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(2);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(3);
        System.out.println(traverse(root));
    }
    static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
//        Queue<per> pq = new PriorityQueue<>(new treeCompare());
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<per> qq = new LinkedList<>();
        qq.add(new per(root,0,0));
        while(!qq.isEmpty()){
            per obj = qq.poll();
            if(!mp.containsKey(obj.l))
                mp.put(obj.l,new TreeMap<>());
            if(!mp.get(obj.l).containsKey(obj.col))
                mp.get(obj.l).put(obj.col,new PriorityQueue<>());
            mp.get(obj.l).get(obj.col).offer(obj.node.val);
            if(obj.node.left!=null){
                qq.add(new per(obj.node.left,obj.l-1,obj.col+1));
            }if(obj.node.right!=null){
                qq.add(new per(obj.node.right,obj.l+1,obj.col+1));
            }

        }
        for(TreeMap < Integer, PriorityQueue < Integer >> ys: mp.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> it : ys.values())
                while(!it.isEmpty()){
                    res.get(res.size()-1).add(it.poll());
                }
        }
        return res;

    }
    static class per{
        TreeNode node;
        int l;
        int col;
        per(TreeNode root,int l,int col){
            node=root;
            this.l=l;
            this.col=col;
        }
    }
    static class treeCompare implements Comparator<per>{

        @Override
        public int compare(per o1, per o2) {
            if(o1.l>o2.l)
                return 1;
            else if(o1.l<o2.l)
                return -1;
            return 0;
        }
    }
}
