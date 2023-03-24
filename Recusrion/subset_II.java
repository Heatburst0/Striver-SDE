package com.company.Striver_SDE.Recusrion;

import java.util.*;

public class subset_II {
    public static void main(String[] args) {
        int[] arr={1,1,2,2};
        System.out.println(subsetII(arr));

    }
    static Set<String> subsets(int[] arr){
        Set<String> res = new HashSet<>();
        List<Integer> dp = new ArrayList<>();
        sub(0,res,dp,arr);
        return res;

    }

    private static void sub(int i, Set<String> res, List<Integer> dp, int[] arr) {
        if(i==arr.length){
            Collections.sort(dp);
            res.add(dp.toString());
            return;
        }
        dp.add(arr[i]);
        sub(i+1,res,dp,arr);
        dp.remove(dp.size()-1);
        sub(i+1,res,dp,arr);
    }
    static List<List<Integer>> subsetII(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        findsubset(0,dp,res,arr);
        return res;
    }

    private static void findsubset(int i, List<Integer> dp, List<List<Integer>> res, int[] arr) {
        res.add(new ArrayList<>(dp));
        for(int ind=i;ind<arr.length;ind++){
            if(i!=ind && arr[ind-1]==arr[ind])
                continue;
            dp.add(arr[ind]);
            findsubset(ind+1,dp,res,arr);
            dp.remove(dp.size()-1);

        }
    }
}
