package com.company.Striver_SDE.Binary_Search;

public class Kth_elemnent {
    public static void main(String[] args) {
        int[] arr1={1,4,8,10};
        int[] arr2 ={2,5,6,7,9};
        System.out.println(find(arr1,arr2,3));
    }
    static int find(int[] arr1,int[] arr2,int k){
        if(arr1.length>arr2.length)
            return find(arr2,arr1,k);
        int med= k-1;
        int low=0;
        int high=arr1.length;
        while(low<=high){
            int cut1=(low+high)>>1;
            int cut2=med-cut1;
            int l1= cut1==0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int l2=cut2==0 ? Integer.MIN_VALUE : arr2[cut2-1];
            int r1= cut1==arr1.length ? Integer.MAX_VALUE : arr1[cut1];
            int r2= cut2==arr2.length ? Integer.MAX_VALUE : arr2[cut2];
            if(l1>r2){
                high=cut1-1;
            }else if(l2>r1)
                low=cut1+1;
            else
                return Math.min(r1,r2);
        }
        return 0;
    }
}
