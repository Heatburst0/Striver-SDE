package com.company.Striver_SDE.BInary_Tree_1;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class pre_in_post_traversal {
    public static void main(String[] args) {

    }
    static List<List<Integer>> traverse(BinaryTreeNode<Integer> root){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair obj = st.pop();
            if(obj.n==1){
                res.get(1).add((Integer) obj.node.data);
                obj.n++;
                st.push(obj);
                if(obj.node.left!=null){
                    st.push(new Pair(obj.node.left,1));
                }
            }else if(obj.n==2){
                res.get(0).add((Integer) obj.node.data);
                obj.n++;
                st.push(obj);
                if(obj.node.right!=null){
                    st.push(new Pair(obj.node.right,1));
                }
            }else{
                res.get(2).add((Integer) obj.node.data);
            }
        }

        return res;


    }
    static class Pair<T>{
        int n;
        BinaryTreeNode<T> node;
        public Pair(BinaryTreeNode<T> node,int l){
            this.node=node;
            n=l;
        }
    }
}
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
