package com.company.Striver_SDE.Recursion_and_backtracking;

import java.util.Arrays;

public class sudoku_solver {
    public static void main(String[] args) {
        char[][] board={
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
//        sudoku(board);
//        for(char[] i : board){
//            System.out.println(Arrays.toString(i));
//        }
//        System.out.println(minJump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,1,1,0,4}));

    }
    static boolean sudoku(char[][] board){
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(board,i,j,k)){
                            board[i][j]=k;
                            if(sudoku(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char k) {
        for(int i=0;i<9;i++){
            if(board[row][i]==k)
                return false;
            if(board[i][col]==k)
                return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==k)
                return false;

        }
        return true;
    }
    static int minJump(int arr[]){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1] = 0;

        for(int i=n-2;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for(int j = i+1; j<=Math.min(n-1,i+arr[i]);j++){

                min = Math.min(min,dp[j]);
            }
            if(min!=Integer.MAX_VALUE){
                dp[i] = min+1;
            }
        }
        return dp[0];
    }
    static boolean jump(int[] arr){
        int i=0;
        int max=Integer.MIN_VALUE;
        int v=0;
        while(i<arr.length-1){
            if(arr[i]==0)
                return false;
            if(arr[i]+i==arr.length-1)
                return true;
            for(int j=i+1;j<=i+arr[i];j++){
                if(arr[j]>max){
                    max=arr[j];
                    v=j;
                }
            }
            max=Integer.MIN_VALUE;
            i=v;
        }
        return true;
    }
 
}
