package com.company.Striver_SDE.Recusrion;

import java.util.ArrayList;
import java.util.List;

public class pallindrome_partioning {
    public static void main(String[] args) {
//        System.out.println(partititon("abaa"));
        System.out.println(power(536870912));

    }
    static boolean power(int n){
        if(n<0){
            return false;
        }
        double x =Math.log((double)n)/Math.log(2);
        int i = (int)x;
        double rem=(double)i%x;
        if(rem==0.0){
            return true;
        }
        return false;


    }
    static List<List<String>> partititon(String s){
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        part(s,0,res,temp);
        return res;
    }

    private static void part(String s, int i, List<List<String>> res, List<String> temp) {
        if(i==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int ind=i;ind<s.length();ind++){
            if(isPall(s,i,ind)){
                temp.add(s.substring(i,ind+1));
                part(s,ind+1,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    private static boolean isPall(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
