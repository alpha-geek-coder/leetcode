package com.training.leetcode;

import java.util.*;

public class SlidingWindowMaximum {
    public static ArrayDeque<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        // write yout code here
        windowSize = windowSize > nums.size() ? nums.size() : windowSize;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.size(); i++) {

            int curr = nums.get(i);
            if (!q.isEmpty() && q.peekFirst() <= i - windowSize) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums.get(q.peekLast()) <= curr) {
                q.pollLast();
            }
            q.offerLast(i);

            if (i >= windowSize - 1) {
                result.add(nums.get(q.peekFirst()));
            }
        }

//        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1] );
//        for(int i = 0; i < nums.length; i++){
//
//            int left = i - k;
//            if(left >= 0){
//                pq.remove(left);
//            }
//            pq.add(i);
//            if(pq.size() == k) res.add(nums[pq.peek()]);
//
//        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums1;
        nums1 = new ArrayList<>(Arrays.asList(-4, -2, -5, 3, 6));
        System.out.println(SlidingWindowMaximum.findMaxSlidingWindow(nums1, 3));
        nums1 = new ArrayList<>(Arrays.asList(-4, 5, 4, -4, 4, 6, 7));
        System.out.println(SlidingWindowMaximum.findMaxSlidingWindow(nums1, 2));
        nums1 = new ArrayList<>(Arrays.asList(-4, 5, 4, -4, 4, 6, 7));
        System.out.println(SlidingWindowMaximum.findMaxSlidingWindow(nums1, 10));
        nums1 = new ArrayList<>(Arrays.asList(3, 3, 3, 3, 3, 3));
        System.out.println(SlidingWindowMaximum.findMaxSlidingWindow(nums1, 3));
        nums1 = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 4, 5, 2, 3, 6));
        System.out.println(SlidingWindowMaximum.findMaxSlidingWindow(nums1, 3));

        int[] nums = new int[]{1};

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num <= 0 || num > n) {
                nums[i] = n + 1; // flag out of bound number
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) continue;
            num--;
            if (nums[num] > 0) {
                nums[num] *= -1; // index found, flag as negative
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) System.out.println(i + 1);
        }

        String senate = "RDD";
        int x = senate.length();

        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();


        for (int i = 0; i < x; i++) {
            char senator = senate.charAt(i);
           if(senator == 'R'){
               radiants.add(i);
           } else {
               dires.add(i);
           }
        }

        while(!radiants.isEmpty() && !dires.isEmpty()){
            int rTurn = radiants.poll();
            int dTurn = dires.poll();

            if(rTurn < dTurn){
                radiants.add(rTurn + x);
            } else {
                dires.add(dTurn + x);
            }
        }

        System.out.println(dires.isEmpty() ? "Radiant" : "Dire");

        int y = 2;
        y = ~y + 1; // same as -y or -2
        System.out.println( y);
    }
}



