package com.company.Striver_SDE.Dynamic_Programming;

public class maxProduct_subarray {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
    public static int maxProduct(int[] arr) {
        if(arr.length==1)
            return arr[0];
        int min=arr[0];
        int max=arr[0];
        int maxprod=1;
        for(int i=1;i<arr.length;i++){
            int tempmin=0;
            int tempmax=0;
            if(arr[i]<0){
                tempmin=Math.min(max*arr[i],arr[i]);
                tempmax=Math.max(min*arr[i],arr[i]);
            }else{
                tempmin=Math.min(min*arr[i],arr[i]);
                tempmax=Math.max(max*arr[i],arr[i]);
            }
            max=tempmax;
            min=tempmin;
            maxprod=Math.max(maxprod,max);
        }
        return maxprod;
    }
    public static int lengthOfLIS(int[] arr) {
        if(arr.length==1){
            return 1;
        }
        int totmax=0;
        int[] dp = new int[arr.length];
        dp[0]=1;
        for(int i=1;i<arr.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    max=Math.max(max,dp[j]);
                totmax=Math.max(totmax,dp[j]);
            }
            dp[i]=Math.max(totmax,max+1);
        }
        return dp[arr.length-1];

    }
}
