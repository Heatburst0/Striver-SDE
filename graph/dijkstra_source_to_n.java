package com.company.Striver_SDE.graph;

import java.util.*;

public class dijkstra_source_to_n {
    public static void main(String[] args) {
        ArrayList< ArrayList < Integer > > vec = new ArrayList<>();
        for(int i=0;i<4;i++) vec.add( new ArrayList<>());
        vec.get(0).add(1);
        vec.get(0).add(5);

        vec.get(0).add(2);
        vec.get(0).add(8);

        vec.get(1).add(2);
        vec.get(1).add(9);

        vec.get(1).add(3);
        vec.get(1).add(2);

        vec.get(2).add(3);
        vec.get(2).add(6);
        dijkstra(vec,4,5,0);

    }
    public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int n, int edges, int source){
        // Write your code here.
        List<List<pair>> graph = new ArrayList<>();
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            parent[i]=i;
        }
        for(int i=0;i<vec.size();i++){
            graph.get(vec.get(i).get(0))
                    .add(new pair(vec.get(i).get(1),vec.get(i).get(2)));
            graph.get(vec.get(i).get(1))
                    .add(new pair(vec.get(i).get(0),vec.get(i).get(2)));

        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        parent[0]=0;
        PriorityQueue<pair> pq = new PriorityQueue<pair>(n, new pair());
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair node=pq.poll();
            for(pair it : graph.get(node.v)){
                if(node.e + it.e < dist[it.v]){
                    dist[it.v]=node.e + it.e;
                    pq.add(new pair(it.v,dist[it.v]));
                    parent[it.v]=node.v;
                }
            }
        }
        ArrayList<Integer> lis = new ArrayList<>();
        int node=n;
        while(parent[node]!=node){
            lis.add(node);
            node=parent[node];
        }
        lis.add(0);
        Collections.reverse(lis);
        return lis;

    }
    static class pair implements Comparator<pair> {
        int v;
        int e;
        pair(int v,int e){
            this.v=v;
            this.e=e;
        }
        pair(){}
        @Override
        public int compare(pair o1, pair o2) {
            if(o1.e < o2.e)
                return -1;
            if(o1.e>o2.e){
                return 1;
            }
            return 0;
        }
    }
}
