package com.company.Striver_SDE.graph;

import java.util.ArrayList;
import java.util.List;

public class bipartite_graph {
    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{4},{},{4},{4},{0,2,3}}));
    }
    public static boolean isBipartite(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[i].length;j++){
                graph.get(i).add(edges[i][j]);
            }
        }
        int[] color=new int[edges.length];
        for(int i=0;i<edges.length;i++){
            if(color[i]==0){
                if(!dfs(i,graph,color,1)) return false;
            }
        }
        return true;

    }
    static boolean dfs(int i, List<List<Integer>> graph, int[] color, int col){
        color[i]=col;
        col= col==1 ? 2 : 1;
        for(int x : graph.get(i)){
            if(color[x]==0){
                if(!dfs(x,graph,color,col)) return false;
            }
            else if(color[x]==color[i]) return false;
        }
        return true;
    }
}
