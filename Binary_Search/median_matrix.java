package com.company.Striver_SDE.Binary_Search;

import java.util.ArrayList;

public class median_matrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(3);
        row.add(6);
        matrix.add(new ArrayList<>(row));
        row.clear();
        row.add(2);
        row.add(6);
        row.add(9);
        matrix.add(new ArrayList<>(row));
        row.clear();
        row.add(3);
        row.add(6);
        row.add(9);
        matrix.add(new ArrayList<>(row));
        System.out.println(median(matrix));
    }


    static int median(ArrayList<ArrayList<Integer>> matrix){
        int min=matrix.get(0).get(0);
        int max=matrix.get(matrix.size()-1).get(matrix.get(0).size()-1);
        for(int i=0;i<matrix.size();i++){
            min=Math.min(min,matrix.get(i).get(0));
            max=Math.max(max,matrix.get(i).get(matrix.get(0).size()-1));
        }
        while(min<=max){
            int middle=(max+min)/2;
            int c=count(matrix,middle);
            if(c<=(matrix.size()*matrix.get(0).size())/2)
                min=middle+1;
            else
                max=middle-1;

        }
        return min;
    }

    private static int count(ArrayList<ArrayList<Integer>> matrix, int x) {
        int num=0;
        for(int i=0;i<matrix.size();i++){
            int l=0;
            int r=matrix.get(0).size()-1;
            while(l<=r){
                int middle=(l+r)/2;
                if(matrix.get(i).get(middle)>x){
                    r=middle-1;
                }else if(matrix.get(i).get(middle)<=x)
                    l=middle+1;
            }
            num+=l;
        }
        return num;
    }
}

