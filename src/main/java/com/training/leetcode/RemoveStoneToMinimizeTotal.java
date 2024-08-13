package com.training.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStoneToMinimizeTotal {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int total = 0;
        for(int pile : piles){
            pq.add(pile);
            total += pile;
        }
        while(k > 0){
            int curr = pq.poll().intValue();
            int remove = curr / 2;
            pq.add(curr - remove);
            total -= remove;
            k--;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveStoneToMinimizeTotal().minStoneSum(new int[]{5,4,9}, 2));
        System.out.println(new RemoveStoneToMinimizeTotal().minStoneSum(new int[]{4,3,6,7}, 3));

    }

}
