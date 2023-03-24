package com.company.Striver_SDE.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class detect_cycle_BFS {
    public static void main(String[] args) {

    }
//    static boolean isCycle()
    public static String cycleDetection(int[][] edges, int n, int m) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i : edges){
            graph.get(i[0]-1).add(i[1]-1);
            graph.get(i[1]-1).add(i[0]-1);
        }
        Queue<pair> qq = new LinkedList<>();
        qq.add(new pair(0,0));
        boolean[] vis= new boolean[n];
        while(!qq.isEmpty()){
            pair node=qq.poll();
            if(!vis[node.x]){
                vis[node.x]=true;
                for(Integer i : graph.get(node.x)){
                    if(vis[i] && i!=node.par) return "Yes";
                    else if(!vis[i]){
                        qq.offer(new pair(i,node.x));
                    }
                }
            }
        }
        return "No";
    }
    static class pair{
        int x;
        int par;
        pair(int x,int par){
            this.x=x;
            this.par=par;
        }
    }
}
