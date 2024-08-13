package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean skip = false;
        for(int[] interval : intervals){
            if(!skip && newInterval[0] < interval[0]){
                list.add(newInterval);
                skip = true;
            }
            list.add(interval);
        }
        if(!skip) list.add(newInterval);
        List<int[]> ans = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            int[] curr = new int[] {list.get(i)[0], list.get(i)[1]};
            while(i < list.size() && doesOverlap(curr, list.get(i))){
                curr = mergeOverlaps(curr, list.get(i));
                i++;
            }
            i--;
            ans.add(curr);
        }

        return ans.toArray(new int[ans.size()][2]);
    }

    public boolean doesOverlap(int[] a, int[] b){
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    public int[] mergeOverlaps(int[] a, int[] b){
        int[] mergedInterval = new int[] {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return mergedInterval;
    }

    public static void main(String[] args) {
        int[][] res1 = new InsertInterval().insert(new int[][] {{1,3},{6,9}}, new int[]{2,5});
        for(int[] interval : res1){
            System.out.println(interval[0] + "," + interval[1]);
        }

        int[][] res2 = new InsertInterval().insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        for(int[] interval : res2){
            System.out.println(interval[0] + "," + interval[1]);
        }


    }
}
