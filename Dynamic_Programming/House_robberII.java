package com.company.Striver_SDE.Dynamic_Programming;

public class House_robberII {
    public static void main(String[] args) {
        rob(new int[]{1,2,1,1});
    }
    public static int rob(int[] arr) {
        if(arr.length==1) return arr[0];
        if(arr.length==2)
            return Math.max(arr[0],arr[1]);
        int dp1[]= new int[arr.length-1];
        int dp2[]= new int[arr.length-1];
        for(int i=0;i<arr.length;i++){
            if(i>0) dp1[i-1]=arr[i];
            if(i!=arr.length-1) dp2[i]=arr[i];
        }
        return Math.max(solve(dp1),solve(dp2));
    }
    static int solve(int arr[]){
        int prev=arr[0];
        int prev2=0;
        for(int i=1;i<arr.length;i++){
            int curr=Math.max(arr[i]+prev2,prev);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
