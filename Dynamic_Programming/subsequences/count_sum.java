package com.company.Striver_SDE.Dynamic_Programming.subsequences;

import java.util.ArrayList;
import java.util.List;

public class count_sum {
    public static void main(String[] args) {
//        findWays(new int[]{1,2,2,3},3);
        uniquePathsWithObstacles(new int[][]{{1,0}});
    }
    public static int findWays(int arr[], int tar) {
        // Write your code here..
        if(arr.length==0) return 0;
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> lis= new ArrayList<>();
        helper(res,lis,arr,tar,0);
        return res.size();
    }
    static void helper(List<List<Integer>> res, List<Integer> lis, int[] arr, int t, int i){
        if(i==arr.length) return;
        if(t==0){
            res.add(new ArrayList<>(lis));
            return;
        }
        if(arr[i]<=t){
            lis.add(arr[i]);
            helper(res, lis, arr, t-arr[i], i+1);
            lis.remove(lis.size()-1);
        }
        helper(res, lis, arr, t, i+1);

    }
    public static int uniquePathsWithObstacles(int[][] grid) {
        boolean ob=false;
        for(int i=0;i<grid.length;i++){
            if(ob) break;
            if(grid[i][0]==1){
                ob=true;
                grid[i][0]=-1;
            }else{
                grid[i][0]=1;
            }
        }
        ob=false;
        for(int i=1;i<grid[0].length;i++){
            if(ob) break;
            if(grid[0][i]==1){
                ob=true;
                grid[i][0]=-1;
            }else{
                grid[0][i]=1;
            }
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                if(grid[i][j]!=1){
                    int u=grid[i-1][j]!=-1 ? grid[i-1][j] : 0;
                    int l=grid[i][j-1]!=-1 ? grid[i][j-1] : 0;
                    grid[i][j]=l+u;
                }else{
                    grid[i][j]=-1;
                }
            }
        }
        int ans=grid[grid.length-1][grid[0].length-1];
        return ans == -1 ?0 : ans;
    }
}
