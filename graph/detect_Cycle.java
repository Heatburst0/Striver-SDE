package com.company.Striver_SDE.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class detect_Cycle {
    public static void main(String[] args) {
        System.out.println(canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}}));

    }
    public static boolean canFinish(int n, int[][] arr) {
        List<List<Integer>> graph =new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i : arr){
            graph.get(i[0]).add(i[1]);
            // graph.get(i[0]).add(i[1]);
        }
        boolean vis[]= new boolean[n];
        boolean df[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(!dfs(graph,vis,i,df)) return false;
            }
        }
        return true;


    }
    static boolean dfs(List<List<Integer>> graph, boolean[] vis, int x, boolean[] df){
        vis[x]=true;
        df[x]=true;
        for(Integer i  : graph.get(x)){
            if(df[i]) return false;
            else if(!vis[i]){
                if(!dfs(graph,vis,i,df)) return false;
            }
        }
        df[x]=false;
        return true;

    }

}
