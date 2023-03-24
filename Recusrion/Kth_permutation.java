package com.company.Striver_SDE.Recusrion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Kth_permutation {
    public static void main(String[] args) {
        System.out.println(permutation(4,17));

    }
    static String perm(int n,int k){
        ArrayList<String> temp = new ArrayList<>();
        String s = n+"";
        find(0,s.toCharArray(),temp);
        Collections.sort(temp);
        return temp.get(k-1);
    }


    private static void find(int i, char[] s, ArrayList<String> temp) {
        if(i==s.length){
            String str = new String(s);
            temp.add(str);
            return;
        }
        for(int ind=i;ind<s.length;ind++){
            swap(s,i,ind);
            find(ind+1,s,temp);
            swap(s,i,ind);
        }
    }

    private static void swap(char[] s, int i, int ind) {
        char temp=s[i];
        s[i]=s[ind];
        s[ind]=temp;
    }
    static int permutation(int n,int k){
        int fact=1;
        ArrayList<Integer> numb = new ArrayList<>();
        for(int i=1;i<n;i++){
            fact=fact*i;
            numb.add(i);

        }
        numb.add(n);
        String ans="";
        k=k-1;
        while(true){
            ans+=numb.get(k/fact)+"";
            numb.remove(k/fact);
            k=k%fact;
            if(numb.size()==0)
                break;
            fact=fact/numb.size();

        }
        return Integer.parseInt(ans);
    }
}
