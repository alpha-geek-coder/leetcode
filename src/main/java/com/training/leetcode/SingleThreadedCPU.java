package com.training.leetcode;

import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];

        PriorityQueue<Integer> sortedTasks = new PriorityQueue<Integer>(
                (a,b) -> Integer.compare(tasks[a][0], tasks[b][0]));
        for(int i = 0; i < tasks.length; i++){
            sortedTasks.add(i);
        }
        PriorityQueue<Integer> availableTasks = new PriorityQueue<Integer>(
                (a,b) -> (tasks[a][1] != tasks[b][1] ? Integer.compare(tasks[a][1], tasks[b][1]) : Integer.compare(a, b))
        );

        int currTime = 0;
        int currProcessTime = 0;
        int ansIdx = 0;
        while(!sortedTasks.isEmpty() || !availableTasks.isEmpty()){
            if(availableTasks.isEmpty() && currTime < tasks[sortedTasks.peek()][0]){
                currTime = tasks[sortedTasks.peek()][0];
            }
            while(!sortedTasks.isEmpty() && currTime >= tasks[sortedTasks.peek()][0]){
                availableTasks.add(sortedTasks.poll());
            }
            currProcessTime = tasks[availableTasks.peek()][1];
            ans[ansIdx++]  = availableTasks.poll();

            currTime += currProcessTime;
        }


        return ans;
    }

    public static void main(String[] args) {
       // System.out.println(new SingleThreadedCPU().getOrder(new int[][]{{1,2},{2,4},{3,2},{4,1}}));
        System.out.println(new SingleThreadedCPU().getOrder(new int[][]{{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}}));
    }
}
