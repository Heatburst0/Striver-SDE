package com.company.Striver_SDE.Binary_Search;

public class single_element {
    public static void main(String[] args) {
        System.out.println(single2(new int[]{1,1,2,3,3,4,4}));
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});

    }
    static int single(int[] arr){
        if(arr.length==1){
            return arr[0];
        }
        int el=arr[0];
        for(int i=1;i<arr.length;i++){
            el=el^arr[i];
        }
        return el;
    }
    static int single2(int[] arr){
        int l=0;
        int r=arr.length-2;
        while(l<=r){
            int middle=(l+r)/2;
            if(middle%2==0){
                if(arr[middle+1]==arr[middle]){
                    l=middle+1;
                }else
                    r=middle-1;
            }else{
                if(arr[middle-1]==arr[middle]){
                    l=middle+1;
                }else
                    r=middle-1;
            }
        }
        return arr[l];
    }
    static int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0]=1;
        int count=1;
        for(int i=1;i<nums.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    max=Math.max(dp[j],max);
                }
            }
            dp[i]=max+1;
            count=Math.max(count,dp[i]);
        }
        return count;
    }
}
