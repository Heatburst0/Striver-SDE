package com.company.Striver_SDE.Recusrion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class combinations_1 {
    public static void main(String[] args) {
        System.out.println(sub(new int[]{10,1,2,7,6,1,5},8));

    }
    static List<List<Integer>> sub(int arr[],int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        sum(target,arr,dp,res,0);
        return res;
    }

    private static void sum(int target, int[] arr, List<Integer> dp, List<List<Integer>> res,int i) {

        if(i==arr.length){
            if(target==0){
                res.add(new ArrayList<>(dp));
            }
            return;

        }

        if(arr[i]<=target){
            dp.add(arr[i]);
            sum(target-arr[i],arr,dp,res,i);
            dp.remove(dp.size()-1);
        }
        sum(target,arr,dp,res,i+1);


    }
}