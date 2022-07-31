package com.company.Striver_SDE.array_4;

import java.util.Arrays;
import java.util.HashMap;

public class two_sum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairs(new int[]{3,2,4},6)));


    }
    static int[] pairs(int[] arr,int target){
        int[] res = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],i);
        }
        for(int i=0;i< arr.length;i++){
            hm.remove(arr[i]);
            if(hm.containsKey(target-arr[i])){
                res[0]=i;
                res[1]=hm.get(target-arr[i]);
                break;
            }

        }
        return res;
    }
}
