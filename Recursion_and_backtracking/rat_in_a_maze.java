package com.company.Striver_SDE.Recursion_and_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rat_in_a_maze {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append('c');
        sb.append('a');
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
        int[][] m={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(rat(m,4));
//        int arr[]={4,0,5,6,3,2};
//        System.out.println(Arrays.toString(convert(arr)));

    }
    static List<String> maze(int[][] m,int n){
        List<String> paths  = new ArrayList<>();
        int i=0;
        int j=0;
        StringBuilder s =new StringBuilder();
        boolean vis[][] = new boolean[n][n];
        if(m[0][0]==1)
            solve(0,0,paths,s,n,m,vis);
        return paths;
    }

    private static void solve(int i, int j, List<String> paths, StringBuilder s, int n, int[][] m, boolean[][] vis) {
        if(i==n-1 && j==n-1){
            paths.add(s.toString());
            return;
        }
        if(j<n-1){
            if(m[i][j+1]==1 && !vis[i][j+1]){
                s.append('R');
                vis[i][j]=true;
                solve(i,j+1,paths,s,n,m, vis);
                s.deleteCharAt(s.length()-1);
                vis[i][j]=false;
            }

        }
        if(i<n-1){
            if(m[i+1][j]==1 && !vis[i+1][j]){
                s.append('D');
                vis[i][j]=true;
                solve(i+1,j,paths,s,n,m, vis);
                s.deleteCharAt(s.length()-1);
                vis[i][j]=false;
            }
        }
        if(j>0){
            if(m[i][j-1]==1 && !vis[i][j-1]){
                s.append('L');vis[i][j]=true;
                solve(i,j-1,paths,s,n,m, vis);
                s.deleteCharAt(s.length()-1);
                vis[i][j]=false;
            }
        }
        if(i>0){
            if(m[i-1][j]==1 && !vis[i-1][j]){
                s.append('U');vis[i][j]=true;
                solve(i-1,j,paths,s,n,m, vis);
                s.deleteCharAt(s.length()-1);
                vis[i][j]=false;
            }
        }

    }
   static int[] convert(int[] arr){
        int maxB=0;
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            maxB=maxB|arr[i];
        }
        int k=0;
        for(int i=0;i<arr.length;i++){
            int or=arr[i];
            int count=0;
            for(int j=i;j<arr.length;j++) {
                if(or<=maxB){
                    or=or|arr[j];
                    count++;
                    if(or==maxB || j==arr.length-1){
                        res[k++]=count;
                        break;
                    }
                }
            }

        }
        return res;
   }
   static ArrayList<String> rat(int[][] arr,int n){
        int di[]={1,0,0,-1};
        int dj[] ={0,-1,1,0};
        boolean vis[][]=new boolean[arr.length][arr.length];
        ArrayList<String> res = new ArrayList<>();
        solve2(di,dj,"",0,0,arr,res,vis);
        return res;
   }

    private static void solve2(int[] di, int[] dj, String s, int i, int j, int[][] arr, ArrayList<String> res, boolean[][] vis) {
        if(i==arr.length-1 && j==arr.length-1){
            res.add(s);
            return;
        }
        String move="DLRU";
        for(int k=0;k<4;k++){
            int nexi=di[k];
            int nexj=dj[k];
            if(nexi>=0 && nexj>=0 && nexi<arr.length && nexj<arr.length && !vis[nexi][nexj] && arr[nexi][nexj]==1){
                vis[nexi][nexj]=true;
                solve2(di,dj,s+move.charAt(k),nexi,nexj,arr,res,vis);
                vis[nexi][nexj]=false;
            }

        }
    }
}
