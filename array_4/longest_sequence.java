package com.company.Striver_SDE.array_4;

import java.util.HashMap;

public class longest_sequence {
    public static void main(String[] args) {
        System.out.println(find(new int[]{3, 8, 5, 7, 6}));
    }
    static int find(int[] arr){
        int count=0;
        int max_xount=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i]-1)){
                int next=arr[i]+1;
                count=1;
                while(hm.containsKey(next)){
                    next++;count++;
                }
                max_xount = Math.max(max_xount,count);
            }
        }
        return max_xount;
    }
}
