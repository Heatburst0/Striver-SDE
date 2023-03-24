package com.company.Striver_SDE.array_1;

public class SellandBuyStock {
    public static void main(String[] args) {
        int[] arr ={7,1,5,3,6,4};
        System.out.println(optimizedProfit(arr));

    }
    //brute force
    static int profit(int[] arr){
        int profit=0;
        int maxProfit=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                profit=arr[j]-arr[i];
                if(profit>0){
                    maxProfit=Math.max(maxProfit,profit);
                }else
                    profit=0;
            }
        }
        return maxProfit;
    }
    //optimized
    static int optimizedProfit(int arr[]){
        int min=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }else{
                maxProfit=Math.max(arr[i]-min,maxProfit);
            }
        }
        return maxProfit;
    }
}
