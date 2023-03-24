package com.company.Striver_SDE.Recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Nqueens{
    public static void main(String[] args) {
        System.out.println(queens(4));

    }
    static List<List<String>> place(int n){
        List<List<String>> res = new ArrayList<>();
        char[][] bord = new char[n][n];
        for(int i=0;i<bord.length;i++){
            for(int j=0;j<n;j++){
                bord[i][j]='.';
            }
        }
        dfs(0,bord,res);
        return res;
    }

    private static void dfs(int row, char[][] bord, List<List<String>> res) {
        if(row==bord.length){
            List<String> temp = new ArrayList<>();
            for(char[] k : bord){
                String s = new String(k);
                temp.add(s);
            }
            res.add(temp);
            return;
        }
        for(int i=0;i<bord.length;i++){
            if(validate(bord,row,i)){
                bord[row][i]='Q';
                dfs(row+1,bord,res);
                bord[row][i]='.';
            }
        }
    }

    private static boolean validate(char[][] bord, int row, int col) {
        int newrow=row;
        int newcol=col;
        while(row>=0 && col>=0){
            if(bord[row][col]=='Q')
                return false;
            row--;
            col--;
        }
        row=newrow;
        col=newcol;
        while(row>=0){
            if(bord[row][col]=='Q')
                return false;
            row--;
        }
        row=newrow;
        col=newcol;
        while(row>=0 && col<bord.length){
            if(bord[row][col]=='Q')
                return false;
            row--;
            col++;
        }
        return true;
    }
    static List<List<String>> queens(int n){
        char[][] board =new char[n][n];
        List<List<String>> res = new ArrayList<>();
        boolean[] leftrow=new boolean[n];
        boolean[] lowerD = new boolean[2*n-1];
        boolean[] upperD = new boolean[2*n-1];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(0,board,res,leftrow,lowerD,upperD);
        return res;
    }

    private static void solve(int i, char[][] board, List<List<String>> res, boolean[] leftrow, boolean[] lowerD, boolean[] upperD) {
        if(i==board.length){
            List<String> temp = new ArrayList<>();
            for(char[] k : board){
                String s = new String(k);
                temp.add(s);
            }
            res.add(temp);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(!lowerD[row+i] && !upperD[board.length-1+(i-row)] && !leftrow[row]){
                leftrow[row]=true;
                board[row][i]='Q';
                upperD[board.length-1+(i-row)]=true;
                lowerD[row+i]=true;
                solve(i+1,board,res,leftrow,lowerD,upperD);
                leftrow[row]=false;
                board[row][i]='.';
                upperD[board.length-1+(i-row)]=false;
                lowerD[row+i]=false;
            }
        }
    }
}
