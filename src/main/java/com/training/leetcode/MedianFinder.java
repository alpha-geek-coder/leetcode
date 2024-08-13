package com.training.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
    PriorityQueue<Integer> greaters = new PriorityQueue<Integer>(); // min heap
    public MedianFinder() {
    }

    public void addNum(int num) {
        if(lowers.isEmpty() || num < lowers.peek()){
            lowers.add(num);
        } else {
            greaters.add(num);
        }

        if(lowers.size() - greaters.size() == 2){
            greaters.add(lowers.poll());
        } else if(greaters.size() - lowers.size() == 2){
            lowers.add(greaters.poll());
        }

    }

    public double findMedian() {
        if(lowers.size() - greaters.size() == 0){
            return ((double) lowers.peek() + (double) greaters.peek()) / 2;
        }else if(lowers.size() > greaters.size()){
            return (double) lowers.peek();
        } else {
            return (double) greaters.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);

        System.out.println(m.findMedian());
        m.addNum(2);
        m.addNum(3);
        m.addNum(4);
        System.out.println(m.findMedian());
        m.addNum(5);
        System.out.println(m.findMedian());
    }
}
