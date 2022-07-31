package com.company.Striver_SDE.array_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class four_sum {
    public static void main(String[] args) {
        System.out.println(sum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));

    }
    static List<List<Integer>> sum(int[] arr,int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-3;i++){
            for(int j=i+1;j<arr.length-2;j++){
                long n=(long)target-(arr[i]+arr[j]);
                int left=j+1;
                int right=arr.length-1;
                while(left<right){
                    List<Integer> temp = new ArrayList<>();
                    if(arr[left]+arr[right]>n){
                        right--;
                    }else if(arr[left]+arr[right]<n){
                        left++;
                    }else{
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[left]);
                        temp.add(arr[right]);
                        res.add(temp);
                        while(left<right && arr[left]==temp.get(2))
                            left++;
                        while(left<right && arr[left]==temp.get(3))
                            right--;
                    }

                }
                while((j+1)<=arr.length-2 && arr[j]==arr[j+1])
                    j++;


            }
            while(i+1<arr.length-3 && arr[i]==arr[i+1])
                i++;
        }
        return res;
    }
}
