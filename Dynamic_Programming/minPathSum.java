package com.company.Striver_SDE.Dynamic_Programming;

public class minPathSum {
    public static void main(String[] args) {
        minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}});
    }
    public static int minFallingPathSum(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(j==0){
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }else if(j==matrix.length-1){
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }else{
                    matrix[i][j]=Math.min(
                            matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i : matrix[matrix.length-1]){
            min=Math.min(min,i);
        }
        return min;

    }
}
