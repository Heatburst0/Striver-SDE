package com.company.Striver_SDE.Binary_Search;

public class search_rotated_array {
    public static void main(String[] args) {

    }
    static int search(int arr[],int target){
        if(arr.length==0){
            return -1;
        }
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int middle=(l+r)/2;
            if(arr[middle]>target){
                if(arr[middle]>arr[r] && arr[r]>=target){
                    l=middle+1;
                }else
                    r=middle-1;
            }else {
                if(arr[middle]<arr[l] && arr[l]<=target){
                    r=middle-1;
                }else
                    l=middle+1;
            }
        }
        return -1;
    }
}
