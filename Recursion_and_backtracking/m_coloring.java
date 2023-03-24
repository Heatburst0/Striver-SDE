package com.company.Striver_SDE.Recursion_and_backtracking;

import java.util.ArrayList;

public class m_coloring {
    public static void main(String[] args) {
        int[][] arr ={{0,1},{1,2},{2,3},{3,0},{0,2}};
        System.out.println(color(arr,3,4));

    }
    static boolean color(int[][] arr,int m,int n){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i : arr ){
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        int[] color = new int[n];
        return solve(0,graph,m,color);
    }

    private static boolean solve(int node, ArrayList<ArrayList<Integer>> graph, int m, int[] color) {
        if(node==color.length)
            return true;
        for(int i=1;i<=m;i++){
            if(issafe(node,color,graph,i)){
                color[node]=i;
                if(solve(node+1,graph,m,color))
                    return true;
                color[node]=0;
            }
        }
        return false;
    }

    private static boolean issafe(int node, int[] color, ArrayList<ArrayList<Integer>> graph, int col) {
        for(int x : graph.get(node)){
            if(color[x]==col)
                return false;
        }
        return true;
    }
}
