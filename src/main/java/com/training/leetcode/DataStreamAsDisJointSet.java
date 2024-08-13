package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DataStreamAsDisJointSet {
        TreeSet<Integer> treeSet;
        public DataStreamAsDisJointSet() {
            treeSet = new TreeSet<>();
        }

        public void addNum(int value) {
            treeSet.add(value);
        }

        public int[][] getIntervals() {
            List<int[]> intervals = new ArrayList<>();
            int left = -1, right = -1;
            for(int value : treeSet){
                if(left == -1 && right == -1){
                    left = value;
                    right = value;
                } else if(right + 1 == value){
                    right = value;
                } else {
                    intervals.add(new int[] {left, right});
                    left = value;
                    right = value;
                }
            }
            intervals.add(new int[] {left, right});
            return intervals.toArray(new int[intervals.size()][2]);
        }

    public static void main(String[] args) {
        DataStreamAsDisJointSet obj = new DataStreamAsDisJointSet();
        obj.addNum(1);      // arr = [1]
        int[][] ans = obj.getIntervals(); // return [[1, 1]]
        obj.addNum(3);      // arr = [1, 3]
        ans = obj.getIntervals(); // return [[1, 1], [3, 3]]
        obj.addNum(7);      // arr = [1, 3, 7]
        ans = obj.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
        obj.addNum(2);      // arr = [1, 2, 3, 7]
        ans = obj.getIntervals(); // return [[1, 3], [7, 7]]
        obj.addNum(6);      // arr = [1, 2, 3, 6, 7]
        ans = obj.getIntervals(); // return [[1, 3], [6, 7]]
    }
}
