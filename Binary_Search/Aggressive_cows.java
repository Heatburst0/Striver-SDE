package com.company.Striver_SDE.Binary_Search;

import java.util.Arrays;

public class Aggressive_cows {
    public static void main(String[] args) {
        int arr[]={1,2,4,8,9,15};
        System.out.println(minDist(arr,4));
    }
    static int minDist(int[] arr,int n){
        int low=1;
        Arrays.sort(arr);
        int high=arr[arr.length-1];
        while(low<=high){
            int mid=(low+high)>>1;
            if(isPossible(arr,mid,n)){
                low=mid+1;
            }else
                high=mid-1;
        }
        return high;
    }

    private static boolean isPossible(int[] arr, int mid, int n) {
        int c=1;
        int pos=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[pos]>=mid){
                pos=i;
                c++;
            }
        }
        if(c<n)
            return false;
        return true;
    }
}
