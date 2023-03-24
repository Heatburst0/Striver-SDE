package com.company.Striver_SDE.array_3;

import java.util.Scanner;

public class power {
    public static void main(String[] args) {
        System.out.println(pow(2,10));
        Scanner sc = new Scanner(System.in);
    }
    static double pow(int x,int n){
        if(n==0){
            return 1.0;
        }
        double ans=1.0;
        long m=n;
        if(n<0)
            m*=-1;
        while (m > 0) {
            if(m%2==0){
                x *= x;
                m=m/2;
            }else{
                ans=ans*x;
                m-=1;
            }
        }
        if(n<0){
            return 1/ans;
        }else{
            return ans;
        }
    }
}
