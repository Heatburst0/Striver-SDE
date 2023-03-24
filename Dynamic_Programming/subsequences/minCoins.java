package com.company.Striver_SDE.Dynamic_Programming.subsequences;

import java.util.Arrays;

public class minCoins {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},3));

    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int ans=solve(coins,amount,dp);
        return ans!=Integer.MAX_VALUE ? ans : -1;

    }
    static int solve(int[] coins,int a,int[] dp){
        if(a==0) return 0;
        if(dp[a]!=Integer.MAX_VALUE) return dp[a];

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=a){
                int ans=solve(coins,a-coins[i],dp);
                if(ans!=Integer.MAX_VALUE)
                dp[a]=Math.min(dp[a],ans+1);
            }
        }
        return dp[a];
    }
}
