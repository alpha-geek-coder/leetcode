package com.training.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
You are given an integer array nums and a positive integer k.
The frequency score of an array is the sum of the distinct values in the array raised to the power of their frequencies, taking the sum modulo 109 + 7.
For example, the frequency score of the array [5,4,5,7,4,4] is (43 + 52 + 71) modulo (109 + 7) = 96.
Return the maximum frequency score of a subarray of size k in nums. You should maximize the value under the modulo and not the actual value.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [1,1,1,2,1,2], k = 3
Output: 5
Explanation: The subarray [2,1,2] has a frequency score equal to 5. It can be shown that it is the maximum frequency score we can have.
Example 2:
Input: nums = [1,1,1,1,1,1], k = 4
Output: 1
Explanation: All the subarrays of length 4 have a frequency score equal to 1.
 */
public class MaximumFreqScoreOfSubarray {
    int mod = (int) 1e9 + 7;
    public int maxFrequencyScore(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        int n = nums.length;
        for(int i = 0; i < k; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        long cur = 0;
        for(Map.Entry<Integer, Integer> e : freq.entrySet()){
            cur += binaryExponentOf(e.getKey(), e.getValue());
        }
        long ans = cur;
        int l = 0, r = k;
        while(r < n){
            int a = nums[l];
            int b = nums[r];
            // if a == b, then ans will be same as previous window, no compute required
            if(a != b){
                if(freq.getOrDefault(b, 0) > 0){
                    cur += (b - 1) * binaryExponentOf(b, freq.get(b)) % mod;
                } else {
                    cur += b;
                }

                if(freq.get(a) > 1){
                    cur -= (a - 1) * binaryExponentOf(a, freq.get(a) - 1) % mod;
                } else {
                    cur -= a;
                }
                cur = (cur + mod) % mod;
                freq.put(a, freq.get(a) - 1);
                freq.put(b, freq.getOrDefault(b, 0) + 1);
                ans = Math.max(ans, cur);
            }
            r++;
        }
        return (int) ans;
    }

    public long binaryExponentOf(int num, int power){
        long ans = 1; // base case num ^ 0 = 1
        while(power > 0){
            if((power & 1) == 1) ans *= num % mod;
            num = num * num % mod;
            power >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumFreqScoreOfSubarray().maxFrequencyScore(new int[]{1,1,1,2,1,2}, 3));
        System.out.println(new MaximumFreqScoreOfSubarray().maxFrequencyScore(new int[]{1,1,1,1,1,1}, 4));
        Comparator<double[]> comparator = new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                // Compare the first elements of the arrays
                return Double.compare(o2[0], o1[0]);
            }
        };
        PriorityQueue<double[]> pq = new PriorityQueue(comparator);
        int[] arr = {1,2,3,5};
        int n = arr.length, k = 3;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                double fraction = (double) arr[i] / arr[j];
                pq.add(new double[]{fraction, arr[i], arr[j]});
                if(pq.size() > k) pq.poll();
            }
        }
        System.out.println((int) pq.peek()[1] + "," + (int) pq.peek()[2]);
    }
}
