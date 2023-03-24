package com.company.Striver_SDE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ninjaTraiing {
    public static void main(String[] args) {
    }
    /* Memoization*/
    static int maxPoints(int n,int[][] points){
        int[][] dp = new int[n][4];
        Arrays.fill(dp, -1);
        return solve(n-1,3,dp,points);
    }

    private static int solve(int day, int last, int[][] dp, int[][] points) {
        if(dp[day][last]!=-1) return dp[day][last];
        if(day==0){
            int max=-1;
            for(int i=0;i<=2;i++){
                if(i!=last)
                    max=Math.max(max,points[day][i]);
            }
            return dp[day][last]=max;
        }
        int max=-1;
        for(int i=0;i<3;i++){
            if(i!=last)
                max=Math.max(max,points[day][i]+solve(day-1,i,dp,points));
        }
        return dp[day][last]=max;
    }
}
