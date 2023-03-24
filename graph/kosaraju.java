package com.company.Striver_SDE.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class kosaraju {
    public static void main(String[] args) {
        System.out.println(stronglyConnectedComponents(5,new int[][]{{0,1},{1,2},{1,4},{2,3},{3,2},{4,0}}));

    }
    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i[] : edges){
            graph.get(i[0]).add(i[1]);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] vis= new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,graph,vis,st);
            }
        }
        List<List<Integer>> graph2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph2.add(new ArrayList<>());
        }
        for(int i[] : edges){
            graph2.get(i[1]).add(i[0]);
        }
        List<List<Integer>> res= new ArrayList<>();
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                List<Integer> lis = new ArrayList<>();
                dfs(i,graph2,vis,lis);
                res.add(new ArrayList<>(lis));
            }
        }
        return res;



    }static void dfs(int x,List<List<Integer>> graph,boolean[] vis,Stack<Integer> st){
        vis[x]=true;
        for(int i : graph.get(x)){
            if(!vis[i]){
                dfs(i,graph,vis,st);
            }
        }
        st.push(x);
    }
    static void dfs(int x,List<List<Integer>> graph,boolean[] vis,List<Integer> lis){
        vis[x]=true;
        lis.add(x);
        for(int i : graph.get(x)){
            if(!vis[i]){
                dfs(i,graph,vis,lis);
            }
        }
    }
}
