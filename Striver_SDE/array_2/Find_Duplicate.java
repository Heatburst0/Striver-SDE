package com.company.Striver_SDE.array_2;

public class Find_Duplicate {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(duplicate(arr));
        System.out.println(duplicateFinder(arr));

    }
    static int duplicate(int[] arr){
        int[] dup= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(dup[arr[i]-1]==0){
                dup[arr[i]-1]++;
            }else
                return arr[i];
        }
        return 0;
    }
    //optimized aproach
    static int duplicateFinder(int[] arr){
        int slow=arr[0];
        int fast = arr[0];
        do{
            slow=arr[slow];
            fast=arr[arr[fast]];
        }while(slow!=fast);
        fast=arr[0];
        while(slow!=fast){
            slow=arr[slow];
            fast=arr[fast];
        }
        return fast;
    }
}
