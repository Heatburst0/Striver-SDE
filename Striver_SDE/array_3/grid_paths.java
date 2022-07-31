package com.company.Striver_SDE.array_3;

import java.util.ArrayList;

public class grid_paths{
    public static void main(String[] args) {
        System.out.println(countOptimal(3,7));

    }
    static int totalPaths(int m, int n){
        int[][] arr = new int[m][n];
        int i=0,j=0;
        ArrayList<ArrayList<Integer>> ht = new ArrayList<>();
        for(int k=0;k<arr.length;k++){
            ht.add(new ArrayList<>());
            for(int l=0;l<arr[k].length;l++){
                ht.get(k).add(-1);
            }
        }
        return count(i,j,arr,ht);
    }

    private static int count(int i, int j, int[][] arr, ArrayList<ArrayList<Integer>> ht) {
        if(i==arr.length || j==arr[0].length){
            return 0;
        }
        if(i==arr.length-1 && j==arr[0].length-1){
            return 1;
        }
        if(i<arr.length && j<arr[0].length){
            if(ht.get(i).get(j)!=-1){
                return ht.get(i).get(j);
            }
        }
        int c=0;
        if(i<arr.length){
            c+=count(i+1,j,arr, ht);
        }
        if(j<arr[0].length){
            c+=count(i,j+1,arr, ht);
        }
        ht.get(i).set(j,c);
        return c;
    }
    //optimal
    static int countOptimal(int m,int n){
        int s=n+m-2;
        int r=m-1;
        int sum=1;
        for(int i=1;i<=r;i++){
            sum=sum*(s-r+i)/i;
        }
        return sum;
    }

}
