package com.company.Striver_SDE.graph;

import java.util.*;

public class AlienLang {
    public static void main(String[] args) {

        System.out.println(findOrder(new String[]{"caa","aaa","aab"},3,3));

    }
    public static String findOrder(String [] dict, int n, int num)
    {
        // Write your code here
        List<List<Integer>> graph = new ArrayList <>();
        for(int i=0;i<num;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegeee= new int[num];
        for(int i=0;i<dict.length-1;i++){
            int k=0;
            while(k<dict[i].length() && k<dict[i+1].length() &&dict[i].charAt(k)==dict[i+1].charAt(k))
                k++;
            if(dict[i].charAt(k)!=dict[i+1].charAt(k)){
                graph.get(dict[i].charAt(k)-97).add(dict[i+1].charAt(k)-97);
                indegeee[dict[i+1].charAt(k)-97]++;
            }
        }
        StringBuilder st = new StringBuilder();
        Queue<Integer> qq = new LinkedList<>();
        for(int i=0;i<num;i++){
            if(indegeee[i]==0){
                qq.add(i);
            }
        }
        boolean[] vis = new boolean[num];
        while(!qq.isEmpty()){
            int node=qq.poll();
            char c= (char)(node+97);
            st.append(c);
            for(int i : graph.get(node)){
                indegeee[i]--;
                if(indegeee[i]==0){
                    qq.add(i);
                }
            }
        }
        if(st.length()==num)
            return new String(st);

        return "";



    }
}
