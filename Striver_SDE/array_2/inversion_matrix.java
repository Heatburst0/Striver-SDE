package com.company.Striver_SDE.array_2;

public class inversion_matrix {
    public static void main(String[] args) {
        int arr[]={5,4,3};
        System.out.println(inverseOptimize(arr,0,arr.length-1));

    }
    //brute force
    static long inverse(int[] arr){
        long total=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    total++;
                }
            }
        }
        return total;
    }
    /** Optimized**/

    static int inverseOptimize(int arr[],int l,int h){
        int total=0;
        if(l<h){
            int middle=(l+h)/2;
            total+=inverseOptimize(arr,l,middle);
            total+=inverseOptimize(arr,middle+1,h);
            total+=conqueror(arr,l,middle,h);
        }
        return total;
    }

    private static int conqueror(int[] arr, int l, int middle, int h) {
        int total=0;
        int[] merge= new int[h-l+1];
        int i=l;
        int j=middle+1;
        int k=0;
        while(i<=middle && j<=h){
            if(arr[i]>arr[j]){
                merge[k]=arr[j];
                total+=middle-i+1;
                j++;

            }else{
                merge[k]=arr[i];i++;
            }
            k++;
        }
        while(i<=middle){
            merge[k]=arr[i];k++;i++;
        }while (j<=h){
            merge[k]=arr[j];k++;j++;
        }
        for(int u=0;u<merge.length;u++){
            arr[l]=merge[u];l++;
        }
        return total;
    }

}
