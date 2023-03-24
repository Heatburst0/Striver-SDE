package com.company.Striver_SDE.Greedy_Algo;

import java.util.Arrays;
import java.util.HashMap;

public class jobs_sequencing {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        job arr[]={new job(1,2,100),new job(2 ,1,9),new job(3 ,2, 27 ),new job(4,1,25),new job(5,1,15)};
        System.out.println(profit(arr));
//        System.out.println(hm.getOrDefault(1,90));
//        System.out.println(hm.getOrDefault(1,80));
//        System.out.println(hm);

    }
    static int profit(job arr[]){
        Arrays.sort(arr,(a,b) -> (b.profit - a.profit));
        int desdline=0;
        int[] res = new int[2];
        int jobs=0;
        int profit=0;
        for(job i : arr){
            desdline = Math.max(i.deadline,desdline);
        }
        int pro[]= new int[desdline];
        for(int i=0;i<arr.length;i++){
            int j=arr[i].deadline;
            while(j>0){
                if(pro[j-1]==0){
                    pro[j-1]=arr[i].profit;
                    jobs++;
                    profit+=arr[i].profit;
                    break;
                }else{
                    j--;
                }
            }
        }
        res[0]=jobs;
        res[1]=profit;
        return profit;

    }
    static class job{
        int id, profit, deadline;
        job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
