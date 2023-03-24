package com.company.Striver_SDE.Greedy_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class knapsack {
    public static void main(String[] args) {
        int[] values={100,60,120};
        int[] weight ={20,10,30};
        System.out.println(knapsackvalues(values,weight,50));

    }
    static double knapsackvalues(int[] values, int[] weight,int w){
        double maxvalues=0.0;
        int wt=0;
       knap[] arr = new knap[values.length];
        for(int i=0;i<values.length;i++){
            arr[i]=new knap(values[i],weight[i]);
        }
        Arrays.sort(arr,new classknapComp());
        for(int i=0;i<arr.length;i++){
            if(wt+arr[i].weight<=w){
                maxvalues+=arr[i].value;
                wt+=arr[i].weight;
            }else{
                double k=(double) (arr[i].value/arr[i].weight);
                double l=(w-wt);
                maxvalues+=k*l;
                break;
            }
        }
        return maxvalues;
    }
    static class knap{
        int value;
        int weight;
        knap(int x,int y){
            this.value=x;
            this.weight=y;
        }
    }
    static class classknapComp implements Comparator<knap> {

        @Override
        public int compare(knap o1, knap o2) {
            double k= (double) o1.value/o1.weight;
            double l= (double) o2.value/o2.weight;
            if(k<l){
                return 1;
            }else if(k>l){
                return -1;
            }
            return 0;
        }
    }
}
