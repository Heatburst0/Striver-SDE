package com.company.Striver_SDE.array_3;

import java.util.Arrays;

public class search_2d {
    public static void main(String[] args) {
        int[][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(Arrays.toString(find(arr,60)));

    }
    static int[] find(int[][] arr,int n){
        int res[]=new int[2];
        if(arr.length==0){
            return res;
        }
        int m=arr[0].length;
        int l=0;
        int h=arr[0].length*arr.length-1;
        while(l<=h){
            int middle=(l+(h-l)/2);
            if(arr[middle/m][middle%m]==n){
                res[0]=middle/m;
                res[1]=middle%m;
                return res;
            }else if(arr[middle/m][middle%m]>n){
                h=middle-1;
            }else{
                l=middle+1;
            }
        }
        return res;
    }
}
