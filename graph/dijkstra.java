package com.company.Striver_SDE.graph;

import java.util.*;

public class dijkstra {
    static class node implements Comparator<node>{
        int v;
        int e;
        node(int v,int e){
            this.v=v;
            this.e=e;
        }
        node(){}

        @Override
        public int compare(node o1, node o2) {
            if(o1.e < o2.e)
                return -1;
            if(o1.e>o2.e){
                return 1;
            }
            return 0;
        }

    }
    static void shortPath(int s, List<List<node>> graph,int n){
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<node> pq = new PriorityQueue<node>(n, new node());
        pq.offer(new node(s,0));
        dist[s]=0;
        while(!pq.isEmpty()){
            node u=pq.poll();
            for(node i : graph.get(u.v)){
                if(i.e+u.e < dist[i.v]){
                    dist[i.v]=i.e+u.e;
                    pq.offer(new node(i.v,dist[i.v]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        List<List<node>> graph= new ArrayList<>();
        for(int i=0;i<5;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new node(1,2));
        graph.get(1).add(new node(0,2));

        graph.get(1).add(new node(2,4));
        graph.get(2).add(new node(1,4));

        graph.get(0).add(new node(3,1));
        graph.get(3).add(new node(0,1));

        graph.get(1).add(new node(4,5));
        graph.get(4).add(new node(1,5));

        graph.get(2).add(new node(4,1));
        graph.get(4).add(new node(2,1));

        graph.get(3).add(new node(2,3));
        graph.get(2).add(new node(3,3));
        shortPath(0,graph,5);
    }
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        // Write your code here
        List<List<node>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                graph.get(i).add(new node(adj.get(i).get(j).get(0),adj.get(i).get(j).get(2)));
                graph.get(adj.get(i).get(j).get(0)).add(new node(i,adj.get(i).get(j).get(2)));
            }
        }
        int[] dist = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<node> pq = new PriorityQueue<node>(v, new node());
        pq.offer(new node(s,0));
        dist[s]=0;
        while(!pq.isEmpty()){
            node u=pq.poll();
            for(node i : graph.get(u.v)){
                if(i.e+u.e < dist[i.v]){
                    dist[i.v]=i.e+u.e;
                    pq.offer(new node(i.v,dist[i.v]));
                }
            }
        }
        return dist;
    }
}
