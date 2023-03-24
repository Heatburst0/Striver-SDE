package com.company.Striver_SDE.Greedy_Algo;

import java.util.*;

public class min_platforms {
    public static void main(String[] args) {
        int[] start ={900, 940, 1100, 950, 1500, 1800};
        int[] end={910, 1200, 1130, 1120, 1900, 2000};
        System.out.println(check(start,end));

    }
    static int check(int[] start,int[] end){
        int count=1;
        int max_count=0;
        Arrays.sort(start);
        Arrays.sort(end);
        int i=1;
        int j=0;
        while(i< start.length && j< start.length){
            while(j<start.length && end[j]<start[i]){
                j++;count--;
            }
            while(i<start.length && end[j]>=start[i]){
                i++;
                count++;
            }
            max_count=Math.max(count,max_count);
        }
        return max_count;
    }
    static class train{
        int start;
        int end;
        train(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    static class comparatorTrain implements Comparator<train>{

        @Override
        public int compare(train o1, train o2) {
            if(o1.start<o2.start){
                return -1;
            }else if(o1.start>o2.start){
                return 1;
            }
            return 1;
        }
    }
}
