package com.company.Striver_SDE.array_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class element_n_by_three {
    public static void main(String[] args) {
        System.out.println(check(new int[]{1,2}));

    }
    static List<Integer> times(int[] arr){
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int nums : arr){
            hm.put(nums,hm.getOrDefault(nums,0)+1);
        }
        for(Integer t : hm.keySet()){
            if(hm.get(t)>arr.length/3){
                res.add(t);
            }
        }
        return res;
    }
    static List<Integer> check(int[] arr){
        List<Integer> res = new ArrayList<>();
        int n1=-1,n2=-1;
        int c1=0,c2=0;
        for(int num : arr){
            if(num==n1){
                c1++;
            }else if(num==n2){
                c2++;
            }
            else if(c1==0){
                n1=num;
                c1++;
            }else if(c2==0){
                n2=num;
                c2++;
            }else{
                c1--;c2--;
            }
        }
        c1=c2=0;
        for(int num : arr){
            if(n1==num){
                c1++;
            }else if(n2==num){
                c2++;
            }
        }
        if(c1>arr.length/3)
            res.add(n1);
        if(c2>arr.length/3){
            res.add(n2);
        }
        return res;

    }
}
