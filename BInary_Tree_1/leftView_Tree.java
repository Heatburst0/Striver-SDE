package com.company.Striver_SDE.BInary_Tree_1;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class leftView_Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n= sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int sum1=0;
            int sum2=0;
            Arrays.sort(arr);
            for(int i : arr){
                if(i<0){
                    sum1=sum1+i;
                }else
                    sum2+=i;
            }
            sum1*=-1;
            int diff=sum1-sum2;
            if(diff<0)
                diff*=-1;
            System.out.println(Math.abs(sum1-sum2));
        }
    }


    static List<Integer> leftView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        lview(root,0,res);
        return res;
    }

    private static void lview(TreeNode root, int i, List<Integer> res) {
        if(root==null)
            return;
        if(i==res.size())
            res.add(root.val);
        lview(root.left,i+1,res);
        lview(root.right,i+1,res);
    }
    static int r(int[] arr){
        int del=0;
        if(arr.length==1){
            if(arr[0]<=1){
                return 0;
            }else{
                return 1;
            }
        }else {
            int i = 0;
            while (i < arr.length) {
                for (int j = i + 1; j < arr.length; j++) {
                    if ((arr[i] ^ arr[j]) > 1) {
                        del++;
                    } else {
                        i = j;
                        break;
                    }
                }
            }
        }
            return del;
    }
    static void p(String s){
        StringBuilder st = new StringBuilder(s);
        while(true){
            if(st.charAt(0)==st.charAt(1)){
                st.deleteCharAt(1);
                st.setCharAt(0,'0');
                if(st.length()==1){
                    System.out.println("YES");
                    break;
                }
            }else{
                System.out.println("NO");
                break;
            }
        }
    }
}
