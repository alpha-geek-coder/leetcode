package com.training.leetcode;

import java.util.*;

public class JumpGame4 {
    /*
    Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
     */

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        boolean[] seen = new boolean[n];

        int jumps = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList();
        q.add(0);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int idx = q.poll();
                seen[idx] = true;
                if(idx == n - 1) return steps;
                if(idx > 0 && !seen[idx - 1]){
                    q.add(idx - 1);
                }
                if(idx < n - 1 && !seen[idx + 1]){
                    q.add(idx + 1);
                }
                for(int j : map.get(arr[idx])){
                    if(j != idx && !seen[j]){
                        q.add(j);
                    }
                }
                steps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame4().minJumps(new int[]{7,7,2,1,7,7,7,3,4,1}));
    }
}
