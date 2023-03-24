package com.company.Striver_SDE.Binary_Search;

public class median_two_matrix {
    public static void main(String[] args) {
        int[] arr1={1,3};
        int[] arr2={2};
        System.out.println(median(arr1,arr2));

    }
    static double median(int[] arr1,int[] arr2){
        if(arr1.length==0 && arr2.length==0)
            return 0;
        if(arr1.length>arr2.length)
            return median(arr2,arr1);
        int low=0;
        int high=arr1.length;
        int mid=(arr1.length+arr2.length+1)/2;
        while(low<=high){
            int cut1=(low+high) >>1;
            int cut2=mid-cut1;
            int l1 = cut1== 0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int l2 = cut2== 0 ? Integer.MIN_VALUE : arr2[cut2-1];
            int r1= cut1==arr1.length ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2==arr2.length ? Integer.MAX_VALUE : arr2[cut2];
            if(l1>r2){
                high=mid-1;
            }else if(l2>r1){
                low=mid+1;
            }else{
                if((arr1.length+arr2.length)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else
                    return Math.max(l1,l2);
            }
        }
        return -1;

    }
}
