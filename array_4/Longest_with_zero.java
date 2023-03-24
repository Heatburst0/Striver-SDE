package com.company.Striver_SDE.array_4;

import java.util.Arrays;
import java.util.HashMap;

public class Longest_with_zero {
    public static void main(String[] args) {
        System.out.println(sum(new int[]{1,0,-5}));

    }
    static int findzero(int[] arr){
        int count=0;
        int max_count=0;
        int sum=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<=0){
                count=0;
                sum=arr[i];
                int j=i+1;count++;
                while(j<arr.length && sum<0){
                    count++;
                    sum+=arr[j];
                    j++;
                    if(count==arr.length && sum==0)
                        return count;
                }
                if(sum==0){
                    max_count=Math.max(max_count,count);
                }
            }
        }
        return max_count;
    }
    static int sum(int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                max=i+1;
            }
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }else{
                max=Math.max(max,i-hm.get(sum));
                if(max==arr.length){
                    return max;
                }
            }
        }
        return max;
    }
}
