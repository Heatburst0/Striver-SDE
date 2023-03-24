package com.company.Striver_SDE.array_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class repeat_and_missing {
    public static void main(String[] args) {
        int[] arr ={3,1,2,5,3};
        System.out.println(Arrays.toString(missingOptimized(arr)));

    }
    static ArrayList<Integer> missing(final List<Integer> arr){
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] temp = new boolean[arr.size()];
        for(int i=0;i< arr.size();i++){
            if(!temp[arr.get(i)-1]){
                temp[arr.get(i)-1]=true;
            }else{
                res.add(arr.get(i));
            }
        }
        for(int i=0;i<temp.length;i++){
            if(!temp[i]){
                res.add(i + 1);
            }
        }
        return res;
    }
    //better approach
    static long[] missingOptimized(int[] arr){
        long res[]= new long[2];
        int n= arr.length;
        long s= (long) n *(n+1)/2;
        long p=n*(n+1)*(2L*n+1)/6;
        for(int i: arr){
            s-=i;
            p-=(long)i*i;
        }
        res[0]=(s+p/s)/2;
        res[1]=res[0]-s;
        return res;


    }
}
