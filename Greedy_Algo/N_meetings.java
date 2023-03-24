package com.company.Striver_SDE.Greedy_Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class N_meetings {
    public static void main(String[] args) {
        int[] start ={1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(meetings(start,end));

    }
    static int meetings(int[] start,int[] end){
        ArrayList<meeting> m = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            m.add(new meeting(start[i],end[i],i+1));
        }
        meetingSort ms = new meetingSort();
        Collections.sort(m,ms);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(m.get(0).pos);
        int limit=m.get(0).end;
        for(int i=1;i<start.length;i++){
            if(m.get(i).start>=limit){
                ans.add(m.get(i).pos);
                limit=m.get(i).end;
            }
        }
        return ans.size();

    }
    static class meeting{
        int start;
        int end;
        int pos;
        meeting(int x,int y , int p){
            this.start=x;
            this.end=y;
            this.pos=p;
        }
    }
    static class meetingSort implements Comparator<meeting>{

        @Override
        public int compare(meeting o1, meeting o2) {
            if(o1.end<o2.end){
                return -1;
            }else if(o1.end>o2.end){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
