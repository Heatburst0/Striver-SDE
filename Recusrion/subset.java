package com.company.Striver_SDE.Recusrion;

import java.util.ArrayList;
import java.util.Collections;

public class subset {
    public static void main(String[] args) {
        int[] arr={3,2,1};
        System.out.println(sum(3,arr));

    }
    static ArrayList<Integer> sum(int n, int arr[]){
        ArrayList<Integer> res = new ArrayList<>();
//        res.add(0);
        if(n==0)
            return res;
        subset(0,n,res,arr,0);
        Collections.sort(res);
        return res;
    }
    static void subset(int i,int n,ArrayList<Integer> res,int[] arr,int sum){
        if(i==n){
            res.add(sum);
            return;
        }
        subset(i+1,n,res,arr,sum+arr[i]);
        subset(i+1,n,res,arr,sum);
    }
}
