package com.company.Striver_SDE.Dynamic_Programming.subsequences;

import java.util.ArrayList;
import java.util.List;

public class subset_sum_k {
    public static void main(String[] args) {
        System.out.println(subsetSumToK(5,4,new int[]{2,5,1,6,7}));
        List<Integer> lis = new ArrayList<>();
        lis.add(1);
        lis.add(1);
        lis.add(1);

    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[] dp = new boolean[k+1];
        dp[0]=true;
        boolean curr[] = new boolean[k+1];
        curr[0]=true;
        if(arr[0]<=k){
            dp[arr[0]]=true;
        }
        for(int i=1;i<n;i++){
            for(int p=1;p<=k;p++){
                boolean t= dp[p];
                boolean nt=false;
                if(arr[i]<=p){
                    nt=dp[p-arr[i]];
                }
                curr[p]=nt||t;
            }
            dp.equals(curr);
        }
        return dp[k];

    }
}
