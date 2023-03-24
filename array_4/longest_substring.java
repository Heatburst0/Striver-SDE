package com.company.Striver_SDE.array_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class longest_substring {
    public static void main(String[] args) {
        System.out.println(suboptimise("aabaab!bb"));

    }
    static int sub(String str){
        if(str.length()==0){
            return 0;
        }
        int count=0;
        int ma_count=0;
        int l=0;
        int r=0;
        HashSet<Character> se = new HashSet<>();
        for(int i=0;i<str.length();i++){
            if(!se.contains(str.charAt(i))){
                se.add(str.charAt(i));
                count=i-l+1;
            }
            else{
                ma_count=Math.max(ma_count,count);
                while(se.contains(str.charAt(i))){
                    se.remove(str.charAt(l));
                    l++;
                }
                se.add(str.charAt(i));
            }
        }
        ma_count=Math.max(ma_count,count);
        return ma_count;
    }

    static int suboptimise(String str){
        int l=0;
        int r=0;
        int max=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(!hm.containsKey(str.charAt(i))){
                hm.put(str.charAt(i),i);
                r=i-l+1;
            }
            else{
                if(l<=hm.get(str.charAt(i))){
                    max=Math.max(max,r);
                    l=hm.get(str.charAt(i))+1;
                }else{
                    r=i-l+1;
                }
                hm.replace(str.charAt(i),i);
            }
        }
        max=Math.max(max,r);
        return max;
    }
}
