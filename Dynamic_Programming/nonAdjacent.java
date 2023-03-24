package com.company.Striver_SDE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

public class nonAdjacent {
    public static void main(String[] args) {
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(5);
        lis.add(6);
        lis.add(6);
        System.out.println(maximumNonAdjacentSum(lis));
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        if (nums.size() == 1) return nums.get(0);

        // Write your code here.
        int prev = nums.get(0);
        int prev2 = 0;
        for (int i = 1; i < nums.size(); i++) {
            int p = nums.get(i) + prev2;
            int np = prev;
            int curr = Math.max(p, np);
            prev = curr;
            prev2 = prev;

        }
        return prev;
    }
    static int solveUtil(int ind, int[] arr, int[] dp){
        if(ind<0)  return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick= arr[ind]+ solveUtil(ind-2, arr,dp);
        int nonPick = 0 + solveUtil(ind-1, arr, dp);

        return dp[ind]=Math.max(pick, nonPick);
    }

    static int solve(int n,int[] arr){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solveUtil(n-1, arr, dp);
    }
}
