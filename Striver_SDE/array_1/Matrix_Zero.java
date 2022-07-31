package com.company.Striver_SDE.array_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix_Zero {
    public static void main(String[] args) {
        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZero2(arr);
        for(int i=0;i<arr.length;i++){
            for(Integer x : arr[i]){
                System.out.print(x+" ");
            }
            System.out.println();
        }

    }
    static void MatrixZero(int[][] arr){
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int k=0;k<arr[i].length;k++){
                if(arr[i][k]==0){
                    lst.add(i);
                    lst.add(k);
                }
            }
        }
        for(int j=0;j<lst.size();j+=2){
            setZero(arr,lst.get(j),lst.get(j+1));
        }
    }

    private static void setZero(int[][] arr, int i, int k) {
        //first row wise
        for(int j=0;j<arr[i].length;j++){
            arr[i][j]=0;
        }
        //then column wise
        for(int j=0;j<arr.length;j++){
            arr[j][k]=0;
        }

    }
    //optimized
    static void setZero2(int[][] arr){
        boolean col=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]==0)
                col=true;
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==0){
                    arr[i][0]=arr[0][j]=0;
                }
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            for(int j=arr[i].length-1;j>=1;j--){
                if(arr[i][0]==0 || arr[0][j]==0){
                    arr[i][j]=0;
                }
            }
            if(col){
                arr[i][0]=0;
            }
        }
    }
}
