package com.company.Striver_SDE.Dynamic_Programming.subsequences;

import java.util.Arrays;

public class unboudedKanpSack {
    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(3,10,new int[]{5,11,13},new int[]{2,4,6}));

    }
    public static int unboundedKnapsack(int n, int w, int[] val, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w+1];
        for(int i=weight[0];i<=w;i++){
            dp[0][i]=(int)(i/weight[0])*val[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=w;j++){
                int nt=dp[i-1][j];
                int t=0;
                if(weight[i]<=j){
                    t=val[i]+dp[i][j-weight[i]];
                }
                dp[i][j]=Math.max(nt,t);
            }
        }
        return dp[n-1][w];

    }
    static int solve(int wt,int[] weight,int[] val,int ind,int[][] dp){
        if(ind==0){
            if(wt>=weight[ind]){
                return solve(wt-weight[0],weight,val,ind,dp)+val[0];
            }else{
                return 0;
            }
        }
        if(dp[ind][wt]!=-1) return dp[ind][wt];

        int nt=solve(wt,weight,val,ind-1,dp);
        int t=0;
        if(weight[ind]<=wt){
            t=solve(wt,weight,val,ind,dp);
        }
        return dp[ind][wt]=Math.max(nt,t);
    }
}
