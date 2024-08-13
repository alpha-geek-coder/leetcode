package com.training.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> prevDurations = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int time = 0;
        for(int[] course : courses){
            int duration = course[0];
            int endDay = course[1];
            if(time + duration <= endDay){
                prevDurations.add(duration);
                time += duration;
            } else if(!prevDurations.isEmpty() && prevDurations.peek() > duration){
                time += duration - prevDurations.poll();
                prevDurations.add(duration);
            }
        }


        return prevDurations.size();
    }

    public static void main(String[] args) {
        System.out.println(new CourseScheduleIII().scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}}));
        System.out.println(new CourseScheduleIII().scheduleCourse(new int[][]{{1,2}}));
        System.out.println(new CourseScheduleIII().scheduleCourse(new int[][]{{3,2},{4,3}}));
        System.out.println(new CourseScheduleIII().scheduleCourse(new int[][]{{5,5},{4,6},{2,6}}));

    }
}
