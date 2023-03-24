package com.company.Striver_SDE.Recusrion;

import java.util.*;

public class combinations_II {
    public static void main(String[] args) {
        System.out.println(comb(new int[]{10,1,2,7,6,1,5},8));

    }
    static ArrayList<ArrayList<Integer>> comb(int[] arr,int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> dp = new ArrayList<>();
        Arrays.sort(arr);
        find(0,arr,dp,res,target);
        return res;
    }

    private static void sum(int i, int[] arr, int target, ArrayList<Integer> dp, HashSet<ArrayList<Integer>> res) {
        if(i==arr.length){
            if(target==0){
                Collections.sort(dp);
                res.add(new ArrayList<>(dp));
            }
            return;
        }
        if(target>=arr[i]){
            dp.add(arr[i]);
            sum(i+1,arr,target-arr[i],dp,res);
            dp.remove(dp.size()-1);
        }
        sum(i+1,arr,target,dp,res);

    }
    static void find(int i,int[] arr,ArrayList<Integer> dp,ArrayList<ArrayList<Integer>> res,int target){
        if(target==0){
            res.add(new ArrayList<>(dp));
            return;
        }
        for(int j=i;j<arr.length;j++){
            if(j>i && arr[j-1]==arr[j])
                continue;
            if(arr[j]>target)
                break;
            dp.add(arr[j]);
            find(j+1,arr,dp,res,target-arr[j]);
            dp.remove(dp.size()-1);
        }
    }
}
