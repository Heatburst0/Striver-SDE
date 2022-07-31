package com.company.Striver_SDE.array_2;

import java.util.Arrays;
import java.util.List;

public class RotsteMatrix_90 {
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        OptimizedRotate(arr);
        for(int i=0;i<arr.length;i++){
            for(Integer x: arr[i]){
                System.out.print(x);
            }
            System.out.println();
        }

    }
    //brute force

    static void rotateMatrix(int[][] arr){
        int[][] newarr = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j= arr[i].length-1;j>=0;j--){
                newarr[i][arr.length-j-1]=arr[j][i];
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=newarr[i][j];
            }
        }

    }
//    Optimized

    static void OptimizedRotate(int[][] arr){
        //first transpose the matrix
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr[i].length;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        //now reverse each row
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length/2;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[i][arr.length-j-1];
                arr[i][arr.length-j-1]=temp;
            }
        }
    }
}
