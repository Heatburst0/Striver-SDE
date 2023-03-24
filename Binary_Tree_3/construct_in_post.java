package com.company.Striver_SDE.Binary_Tree_3;

import com.company.Striver_SDE.Recusrion.TreeNode;

import java.util.HashMap;

public class construct_in_post {
    public static void main(String[] args) {
        int[] p={9,15,7,20,3};
        int[] i={9,3,15,20,7};
        construct(p,i);
        int[] arr={8,7,9,8,4,6,2,8};
        System.out.println(res(arr));
        System.out.println(check("QAA"));

    }
    static TreeNode construct(int[] post,int in[]){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<in.length;i++){
            hm.put(in[i],i);
        }
        TreeNode root=build(hm,post,in,0,post.length-1,0,in.length-1);
        return root;
    }

    private static TreeNode build(HashMap<Integer, Integer> hm, int[] post, int[] in, int postStart, int postEnd, int inStart, int inEnd) {

        if(postStart>postEnd || inStart>inEnd)
            return null;
        TreeNode root=new TreeNode(post[postEnd]);
        int ind=hm.get(post[postEnd]);
        int indleft=ind-inStart;
        root.left=build(hm,post,in,postStart,postStart+indleft-1,inStart,ind-1);
        root.right=build(hm,post,in,postStart+indleft,postEnd-1,ind+1,inEnd);
        return root;
    }
    static boolean res(int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : arr){
            if(!hm.containsKey(i)){
                hm.put(i,1);
            }else{
                if((hm.get(i)+1)>2)
                    return false;
                else{
                    hm.replace(i,hm.get(i)+1);
                }
            }
        }
        return true;
    }
    static boolean check(String s){
        int q=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='Q')
                q++;
            else{
                if(q>0)
                    q--;
            }
        }
        return q == 0;
    }
}
