package com.company.Striver_SDE.array_1;

import java.util.ArrayList;

public class LargestSum {
    public static void main(String[] args) {
        int arr[]={-2,-1};
        System.out.println(sumOptimized(arr));

    }
    //naive
    static ArrayList<Integer> index = new ArrayList<>();
    static long sum(int arr[]){

        if(arr.length==1){
            return arr[0];
        }
        int sum=0;
        long sumMax=Integer.MIN_VALUE;
        int j=0;
        for(int i=0;i<arr.length;i++){
            sum=0;
            j=i;
            while(j<arr.length){
                sum+=arr[j];
                if(sum>sumMax){
                    sumMax = Math.max(sumMax,sum);
                    index.clear();
                    index.add(i);
                    index.add(j);
                }
                j++;
            }
        }
        return sumMax;
    }
    //improved
    static int sumOptimized(int[] arr){
        if(arr.length==1){
            return arr[0];
        }
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int start=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            maxSum = Math.max(sum,maxSum);
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }

}
