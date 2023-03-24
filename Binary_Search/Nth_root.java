package com.company.Striver_SDE.Binary_Search;

public class Nth_root {
    public static void main(String[] args) {
        System.out.println(root(3,53));
    }
    static double root(int n,int m){
        if(n==1 || m==1){
            return m;
        }
        double l=1.0;
        double h=(double)m;
        double middle=0.0;
        while(h-l>(1e-7)){
            middle=(double)(l+h)/2;
            if(Math.pow(middle,n)==m){
                return middle;
            }else if(Math.pow(middle,n)>m){
                h=middle;
            }else{
                l=middle;
            }
        }
        return middle;
    }
}
