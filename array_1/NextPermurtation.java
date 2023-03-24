package com.company.Striver_SDE.array_1;

import java.util.Arrays;

public class NextPermurtation {
    public static void main(String[] args) {
        int[] arr = {4,1,5,3,2};
        next(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void findNextPerm(int arr[]){
        if(arr.length<=1){
            return;
        }
        int i=arr.length-2;
        while(i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        if(i>=0){
            int j=arr.length-1;
            while(j>=0 && arr[i]>=arr[j]){
                j--;
            }
            swap(arr,i,j);
        }
        reverse(arr,i+1);
    }

    private static void reverse(int[] arr, int i) {
        int j=arr.length-1;
        while(i<j){
            swap(arr,i,j);
            i++;j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void next(int[] arr){
        if(arr.length==1){
            return;
        }
        int ind=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1)
            return;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>arr[ind]){
                int temp=arr[i];
                arr[i]=arr[ind];
                arr[ind]=temp;
                break;
            }
        }
        reversearr(ind+1,arr);
    }

    private static void reversearr(int ind, int[] arr) {
        int j=arr.length-1;
        while(ind<j){
            int temp=arr[ind];
            arr[ind]=arr[j];
            arr[j]=temp;
            ind++;j--;
        }
    }
}
