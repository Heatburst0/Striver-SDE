package com.company.Striver_SDE.graph;

import java.util.ArrayList;
import java.util.List;

public class Number_Islands {
    public static void main(String[] args) {
        numIslands(new char[][]{{'1'},{'1'}});
    }
    public static int numIslands(char[][] grid) {
        int m=grid[0].length;
        int n=grid.length;
        boolean vis[][] = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return count;


    }
    static void dfs(int i,int j,boolean[][] vis,char[][] grid){
        vis[i][j]=true;
        int[] n={1,0,-1,0};
        int[] m={0,1,0,-1};
        for(int l=0;l<4;l++){
            int row=i+n[l];
            int col=j+m[l];
            if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && !vis[row][col]
                    && grid[row][col]=='1'){
                dfs(row,col,vis,grid);
            }
        }

    }
}
