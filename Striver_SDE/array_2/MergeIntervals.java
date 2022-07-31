package com.company.Striver_SDE.array_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,4},{0,2},{3,5}};
        System.out.println(Arrays.toString(merge(arr)));
    }
    static int[][] merge(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if(first[0] > second[0]) return 1;
                else return -1;
            }
        });
        ArrayList<int[]> merged = new ArrayList<>();
        if(arr.length==0){
            return arr;
        }
        int start=arr[0][0];
        int end=arr[0][1];
        for(int[] it : arr){
            if(end>=it[0]){
                end=Math.max(end,it[1]);
            }else{
                merged.add(new int[]{start,end});
                start=it[0];
                end=it[1];

            }
        }
        merged.add(new int[]{start,end});
        return merged.toArray(new int[0][]);

    }
}
