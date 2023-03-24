package com.company.Striver_SDE.array_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_two_arr {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7};
        int[] arr2={0,2,6,8,9};
        mergeOptimize(arr1,arr2);
        System.out.println(Arrays.toString(arr1)+" "+Arrays.toString(arr2));

    }
    static void merger(int[] arr1,int[] arr2){
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr1[j]>arr2[i]){
                    int temp=arr1[j];
                    arr1[j]=arr2[i];
                    arr2[i]=temp;
                }
            }
        }
//        Arrays.sort(arr2);
        int temp=arr2[0];
        int pos=1;
        while(pos<arr2.length && arr2[pos]<temp){
            arr2[pos-1]=arr2[pos];
            pos++;
        }
        pos--;
        arr2[pos]=temp;
    }
    //using gap method
    static void mergeOptimize(int arr[], int arr2[]){
        int gap = (arr.length+arr2.length)/2;
        while(gap>0){
            int i=0;
            int j=gap;
            while(j<(arr.length+arr2.length)){
                if(j<arr.length && arr[i]>arr[j]){
                     int temp=arr[i];
                     arr[i]=arr[j];
                     arr[j]=temp;
                }else if(j>=arr.length && i<arr.length && arr[i]>arr2[j-arr.length]){
//                    swap(arr[i],arr2[j-arr.length]);
                    int temp=arr2[j-arr.length];
                    arr2[j-arr.length]=arr[i];
                    arr[i]=temp;
                }else if(j>arr.length && i>arr.length && arr2[i-arr.length]>arr2[j-arr.length]){
                    int temp=arr2[i-arr.length];
                    arr2[i-arr.length]=arr2[j-arr.length];
                    arr2[j-arr.length]=temp;
                }
                i++;
                j++;
            }
            if(gap==1){
                gap=0;
            }else{
                gap=gap/2;
            }
        }
    }

    private static void swap(int i, int i1) {
        int temp=i;
        i=i1;
        i1=temp;
    }
}
