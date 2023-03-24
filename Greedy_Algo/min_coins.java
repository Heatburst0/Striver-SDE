package com.company.Striver_SDE.Greedy_Algo;

public class min_coins {
    public static void main(String[] args) {
        System.out.println(count(100000));

    }
    static int coins(int n){
        int pisa[] ={1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int c=0;
        int orig=n;
        int currMoney=0;
        int minDiff=Integer.MAX_VALUE;
        while(currMoney<orig && n%1000==0){
            c++;
            n=n-1000;
            currMoney+=1000;
        }
        while(currMoney<orig){
            for(int i=0;i<pisa.length;i++){
                if(n-pisa[i]<minDiff && n-pisa[i]>=0){
                    minDiff=n-pisa[i];
                }else {
                    currMoney+=pisa[i-1];
                    c++;
                    n-=pisa[i-1];
                    break;
                }

            }
            if(n-pisa[pisa.length-1]>0){
                c++;
                currMoney+=pisa[pisa.length-1];
                n-=pisa[pisa.length-1];
            }
            minDiff=Integer.
                    MAX_VALUE;
        }
        return c;
    }
    static int count(int n){
        int c=0;
        int pisa[]={1, 2, 5, 10, 20, 50, 100, 500, 1000};
        for(int i=pisa.length-1;i>=0;i--){
            while(n>=pisa[i]){
                c++;
                n-=pisa[i];
            }
        }
        return c;
    }
}
