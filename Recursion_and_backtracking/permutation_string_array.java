package com.company.Striver_SDE.Recursion_and_backtracking;

import java.util.*;

public class permutation_string_array {
    public static void main(String[] args) {
        System.out.println(perm(new int[]{1,2,3}));
//        System.out.println(times(new int[]{3,2,3}));

    }
    static List<List<Integer>> perm(int arr[]){
        List<List<Integer>> res = new ArrayList<>();
        find(0,res,arr);
        return res;
    }

    private static void find(int i, List<List<Integer>> res, int[] arr) {
        if(i==arr.length){
            List<Integer> temp = new ArrayList<>();
            for(int x : arr){
                temp.add(x);
            }
            res.add(temp);
            return;
        }
        for(int ind=i;ind<arr.length;ind++){
            swap(arr,i,ind);
            find(i+1,res,arr);
            swap(arr,i,ind);
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
//    static int times(int[] arr){
//        HashMap<Integer,Integer> hm = new HashMap<>();
//        for(int i=0;i<arr.length;i++){
//            if(!hm.containsKey(arr[i])){
//                hm.put(arr[i],1);
//            }else{
//                hm.replace(arr[i],hm.get(arr[i])+1);
//                if(hm.get(arr[i])>=arr.length/2){
//                    return arr[i];
//                }
//            }
//        }
//        return 0;
//    }
}
