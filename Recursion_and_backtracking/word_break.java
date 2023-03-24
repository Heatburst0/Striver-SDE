package com.company.Striver_SDE.Recursion_and_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class word_break {
    public static void main(String[] args) {
//        String s="I like pep coding";
//        String arr[]= s.split(" ");
//        System.out.println(Arrays.toString(arr));
//        System.out.println(words("god is no here","godisnowhere"));
    }
    static ArrayList<String> words(ArrayList<String> dict,String s){
        HashMap<String,Integer> hm = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<dict.size();i++){
            hm.put(dict.get(i),i);
        }
        solve(hm,s,0,res,"");
        return res;
    }

    private static void solve(HashMap<String, Integer> hm, String s, int i, ArrayList<String> res, String line) {
        if(i==s.length()){
            res.add(line);
            return;
        }
        for(int ind=i;ind<s.length();ind++){
            if(hm.containsKey(s.substring(i,ind+1))){
                solve(hm,s,ind+1,res,line+" "+s.substring(i,ind+1));
            }
        }
    }
}
