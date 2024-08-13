package com.training.leetcode;

import java.util.TreeSet;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        PriorityQueue<Integer> lowers = new PriorityQueue(Collections.reverseOrder());
//        PriorityQueue<Integer> greaters = new PriorityQueue();
//        double[] ans = new double[n - k + 1];
//        int start = 0, idx = 0;
//        for(int end = 0; end < n; end++){
//            int num = nums[end];
//            greaters.add(num);
//            lowers.add(greaters.poll());
//            if(lowers.size() > greaters.size()){
//                greaters.add(lowers.poll());
//            }
//            if(end - start + 1 == k){
//                // remove start element
//                if(lowers.size() - greaters.size() == 0){
//                    ans[idx++] = ((double) lowers.peek() + (double) greaters.peek()) / 2;
//                } else if(lowers.size() > greaters.size()){
//                    ans[idx++] = (double) lowers.peek();
//                } else {
//                    ans[idx++] = (double) greaters.peek();
//                }
//                if(!lowers.isEmpty() && nums[start] <= lowers.peek()){
//                    lowers.remove(nums[start++]);
//                } else {
//                    greaters.remove(nums[start++]);
//                }
//                if(lowers.size() > greaters.size()){
//                    greaters.add(lowers.poll());
//                }
//
//            }
//        }
//        return ans;
        int n = nums.length;

        TreeSet<Integer> lowers = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]));
        TreeSet<Integer> greaters = new TreeSet<>((a,b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]));
        double[] ans = new double[n - k + 1];
        int start = 0, idx = 0;
        for(int end = 0; end < n; end++){

            if(lowers.size() <= greaters.size()){
                greaters.add(end);
                lowers.add(greaters.pollFirst());
            } else {
                lowers.add(end);
                greaters.add(lowers.pollLast());
            }
            if(end - start + 1 == k){
                // remove start element
                if(k % 2 == 0){
                    ans[idx++] = ((double) nums[lowers.last()] + (double) nums[greaters.first()]) / 2;
                }else {
                    ans[idx++] = (double) nums[lowers.last()];
                }
                if(lowers.contains(start)){
                    lowers.remove(start++);
                } else {
                    greaters.remove(start++);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new SlidingWindowMedian().medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));

//        System.out.println(new SlidingWindowMedian().medianSlidingWindow(new int[]{2147483647,1,2,3,4,5,6,7,2147483647}, 2));

        System.out.println(Math.atan2(2,2));
        System.out.println(Math.atan(0.577));

    }
}
