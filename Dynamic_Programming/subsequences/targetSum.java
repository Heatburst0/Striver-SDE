package com.company.Striver_SDE.Dynamic_Programming.subsequences;

import java.util.Arrays;

public class targetSum {
    public static void main(String[] args) {
        int i='d';
        System.out.println(i%97);
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int tot=0;
        for(int i : nums) tot+=i;
        if(target>tot) return 0;
        if((tot-target)%2==1) return 0;
        int s1=(tot+target)/2;

        int[][] dp = new int[n][s1+1];
        for(int i[] : dp)
            Arrays.fill(i,-1);;
        return solve(nums,n-1,s1,dp);

//   ;
    }
    static int solve(int[] arr,int ind,int target,int[][] dp){
        if(ind==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];

        int nt=solve(arr,ind-1,target,dp);
        int t=0;
        if(arr[ind]<=target){
            t=solve(arr,ind-1,target-arr[ind],dp);
        }
        return dp[ind][target]=t+nt;

    }
}
