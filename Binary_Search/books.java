package com.company.Striver_SDE.Binary_Search;

import java.util.ArrayList;

public class books {
    public static void main(String[] args) {
        System.out.println(minPages(new int[]{12,34,67,90},4));
        ArrayList<Integer> lsi = new ArrayList<>();

    }
    static int minPages(int[] arr,int n){
        if(n>arr.length)
            return -1;
        int low=0;
        int high =sum(arr);
        while(low<=high){
            int med=(low+high) >> 1;
            if(possible(arr,med,n)){
                high=med-1;
            }else
                low=med+1;
        }
        return low;
    }

    private static boolean possible(int[] arr, int med, int n) {
        int count=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>med)
                return false;
            if(sum+arr[i]>med){
                count++;
                if(count>n)
                    return false;
                sum=arr[i];
            }else{
                sum+=arr[i];
            }
        }
        return true;
    }

    private static int sum(int[] arr) {
        int sum=0;
        for(int i : arr)
            sum+=i;
        return sum;
    }
}
