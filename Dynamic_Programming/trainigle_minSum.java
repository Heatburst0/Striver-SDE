package com.company.Striver_SDE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class trainigle_minSum {
    public static void main(String[] args) {
        List<List<Integer>> lis = new ArrayList<>();
        lis.add(new ArrayList<>());
        lis.add(new ArrayList<>());
        lis.add(new ArrayList<>());
        lis.add(new ArrayList<>());
        lis.get(0).add(2);
        lis.get(1).add(3);
        lis.get(1).add(4);
        lis.get(2).add(6);
        lis.get(2).add(5);
        lis.get(2).add(7);
        lis.get(3).add(4);
        lis.get(3).add(1);
        lis.get(3).add(8);
        lis.get(3).add(3);
        System.out.println(minimumTotal(lis));

    }
    public static int minimumTotal(List<List<Integer>> lis) {
        for(int i=1;i<lis.size();i++){
            lis.get(i).set(0,lis.get(i-1).get(0)+lis.get(i).get(0));
            int last=lis.get(i).size()-1;
            int prev=lis.get(i-1).size()-1;
            lis.get(i).set(last,lis.get(i-1).get(prev)+lis.get(i).get(last));
        }
        for(int i=2;i<lis.size();i++){
            for(int j=1;j<lis.get(i).size()-1;j++){
                int x=lis.get(i-1).get(j-1);
                int y=lis.get(i-1).get(j);
                int val=lis.get(i).get(j);
                lis.get(i).set(j,Math.min(x,y)+val);

            }
        }
        int min=Integer.MAX_VALUE;
        for(int i : lis.get(lis.size()-1)){
            min=Math.min(min,i);
        }
        return min;

    }
}
