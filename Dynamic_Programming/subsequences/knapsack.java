package com.company.Striver_SDE.Dynamic_Programming.subsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class knapsack {
    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{1 ,2 ,4 ,5}, new int[]{5 ,4 ,8 ,6},4,5));
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        List<pair> lis = new ArrayList<>();
        for(int i=0;i<weight.length;i++){
            lis.add(new pair(value[i],weight[i]));
        }
        Collections.sort(lis, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o2.val-o1.val;
            }
        });
        int currw=0;
        int tot=0;
        for(int i=0;i<weight.length;i++){
            if(currw+lis.get(i).wet<=maxWeight){
                tot+=lis.get(i).val;
                currw+=lis.get(i).wet;
            }
        }
        return tot;

    }
    static class pair{
        int val;
        int wet;
        pair(int v,int w){
            val=v;
            wet=w;
        }
    }
}
