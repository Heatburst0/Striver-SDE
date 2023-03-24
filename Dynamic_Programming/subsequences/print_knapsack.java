package com.company.Striver_SDE.Dynamic_Programming.subsequences;

import java.util.ArrayList;
import java.util.List;

public class print_knapsack {
    public static void main(String[] args) {
        System.out.println(printknapsack(new int[]{1, 2, 3},new int[]{4, 5, 1},3));
    }
    static List<Integer> printknapsack(int[] price, int[] weight,int w){
        int[][] dp = new int[price.length][w+1];
        for(int i=weight[0];i<=w;i++){
            dp[0][i]=price[0];
        }
        for(int i=1;i<price.length;i++){
            for(int j=1;j<=w;j++){
                int nt=dp[i-1][j];
                int t=0;
                if(j>=weight[i]){
                    t=price[i]+dp[i-1][j-weight[i]];
                }
                dp[i][j]=Math.max(nt,t);
            }
        }
        List<Integer> res = new ArrayList<>();
        int i=price.length-1;
        int j=w;
        int total=0;
        while(i>=0 && j>=0 &&dp[i][j]!=0){
            if(i==0 && total+dp[i][j]==dp[price.length-1][w]) {
                res.add(price[i]);break;
            }
            else if(dp[i][j]==dp[i-1][j]){
                i--;
            }else{
                res.add(price[i]);
                total+=price[i];
                j=j-weight[i];
                i--;
            }
        }
        return res;
    }
}
