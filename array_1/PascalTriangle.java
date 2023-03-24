package com.company.Striver_SDE.array_1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(pascal(10));
    }
    static List<List<Integer>> pascal(int n){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        int pointer=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(j==1 || j==i){
                    res.get(i-1).add(1);
                    continue;
                }
                pointer++;
                res.get(i-1).add(res.get(i-2).get(pointer-1)+res.get(i-2).get(pointer));
            }
            pointer=0;
        }
        return res;
    }
}
