package com.company.Striver_SDE.array_3;

import java.util.HashMap;

public class longest_xor {
    public static void main(String[] args) {
        System.out.println(longest(new int[]{5, 6, 7, 8, 9},5));

    }
    static int longest(int[] arr,int k){
        int cout=0;
        int xor=0;
        int y=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            if(xor==k)
                cout++;
            y=xor^k;
            if(!hm.containsKey(y)){
                if(!hm.containsKey(xor)){
                    hm.put(xor,1);
                }else{
                    hm.replace(xor,hm.get(xor),hm.get(xor)+1);
                }
            }else{
                cout+=hm.get(y);
            }
        }
        return cout;
    }
}
