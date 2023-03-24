package com.company.Striver_SDE.array_3;

public class Reverse_paths {
    public static void main(String[] args) {
        System.out.println(pairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));

    }
    static int pairs(int[] arr){
       return mergeSort(arr,0,arr.length-1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        int count=0;
        if(l<r){

            int middle =(l+r)/2;
            count+=mergeSort(arr,l,middle);
            count+=mergeSort(arr,middle+1,r);
            count+=conqueror(arr,l,middle,r);
        }
        return count;
    }

    private static int conqueror(int[] arr, int l, int middle, int r) {
        int count=0;
        int j=middle+1;
        int k=0;
        for(int i=l;i<=middle;i++){
            while(j<=r && arr[i]>(long)2*arr[j]){
                j++;
            }
            count+=(j-(middle+1));
        }
        j=middle+1;
        int i=l;
        int[] merge= new int[r-l+1];
        while(i<=middle && j<=r){
            if(arr[i]>arr[j]){
                merge[k]=arr[j];
                j++;

            }else{
                merge[k]=arr[i];i++;
            }
            k++;
        }
        while(i<=middle){
            merge[k]=arr[i];k++;i++;
        }while (j<=r){
            merge[k]=arr[j];k++;j++;
        }
        for(int u=0;u<merge.length;u++){
            arr[l]=merge[u];l++;
        }
        return count;

    }
}
