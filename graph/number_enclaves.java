package com.company.Striver_SDE.graph;

public class number_enclaves {
    static boolean set;
    public static void main(String[] args) {
        int[][] grid= {{0,0,1,1,1,0,1,1,1,0,1},{1,1,1,1,0,1,0,1,1,0,0},{0,1,0,1,1,0,0,0,0,1,0},{1,0,1,1,1,1,1,0,0,0,1},{0,0,1,0,1,1,0,0,1,0,0},{1,0,0,1,1,1,0,0,0,1,1},{0,1,0,1,1,0,0,0,1,0,0},{0,1,1,0,1,0,1,1,1,0,0},{1,1,0,1,1,1,0,0,0,0,0},{1,0,1,1,0,0,0,1,0,0,1}}
                ;
        System.out.println(numEnclaves(grid));
        String st="[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]";
        st=st.replace('[','{');
        st=st.replace(']','}');
        System.out.println(st);


    }
    public static int numEnclaves(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1 && !vis[i][0]){
                dfs(i,0,vis,grid);
            }
            if(grid[i][grid[0].length-1]==1 && !vis[i][grid[0].length-1]){
                dfs(i,grid[0].length-1,vis,grid);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==1 && !vis[0][i]){
                dfs(0,i,vis,grid);
            }
            if(grid[grid.length-1][i]==1 && !vis[grid.length-1][i]){
                dfs(grid.length-1,i,vis,grid);
            }
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]==1) count++;
            }
        }
        return count;


    }
    static void dfs(int i,int j,boolean[][] vis,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j]==0)
            return;
        vis[i][j]=true;
        dfs(i-1,j,vis,grid);
        dfs(i+1,j,vis,grid);
        dfs(i,j-1,vis,grid);
        dfs(i,j+1,vis,grid);
    }
}
