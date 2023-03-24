package com.company.Striver_SDE.Dynamic_Programming.subsequences;

public class rod_cutting {
    public static void main(String[] args) {
        cutRod(new int[]{2,5,7,8,10},5);
    }
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int[][] dp = new int[price.length][n+1];
        for(int i=1;i<=n;i++){
            dp[0][i]=price[0]*i;
        }
        for(int i=1;i<price.length;i++){
            for(int j=1;j<=n;j++){

                int nt=dp[i-1][j];
                int t=0;
                if(j>=i){
                    t=price[i-1]+dp[i][j-i-1];
                }
                dp[i][j]=Math.max(nt,t);

            }
        }
        return dp[price.length-1][n];
    }
}
