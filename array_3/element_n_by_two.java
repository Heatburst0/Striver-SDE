package com.company.Striver_SDE.array_3;

import java.util.ArrayList;

public class element_n_by_two {
    public static void main(String[] args) {
        System.out.println(find(new int[]{2,2,1,1,1,2,2}));
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(3);
        ar.add(3);
        ar.add(3);
        ar.add(1);
        ar.remove(new Integer(3));
        System.out.println(ar);



    }
    static int find(int[] arr){
        int count =0;
        int n=0;
        for(int num : arr){
            if(count==0){
                n=num;
            }
            if(n==num){
                count++;
            }
            else
                count--;
        }
        return n;
    }
}
