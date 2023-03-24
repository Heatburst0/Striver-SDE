package com.company.Striver_SDE.Dynamic_Programming;

public class frogJump {
    public static void main(String[] args) {
        frogJumpI(8,new int[]{7,4,4,2,6,6,3,4 });
    }
    public static int frogJumpI(int n, int arr[]) {

        // Write your code here..
        if(arr.length==2) return arr[1]-arr[0];
        int dp[] = new int[n];
        dp[1]=arr[1]-arr[0];
        for(int i=2;i<n;i++){
            int x=Math.abs(arr[i]-arr[i-1])+dp[i-1];
            int y=Math.abs(arr[i]-arr[i-2])+dp[i-2];
            dp[i]=Math.min(x,y);
        }
        return dp[n-1];

    }
}
