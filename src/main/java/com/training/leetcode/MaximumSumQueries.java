package com.training.leetcode;

import java.util.*;

public class MaximumSumQueries {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {

        int m = queries.length, n = nums1.length;

        int[][] sorted_nums = new int[n][2];
        for(int i = 0 ; i < n; i++){
            sorted_nums[i] = new int[]{nums1[i], nums2[i]};
        }

        Arrays.sort(sorted_nums, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);



        int[][] sorted_queries = new int[m][3];
        for(int i = 0; i < m; i++){
            sorted_queries[i] = new int[]{queries[i][0], queries[i][1], i};
        }

        Arrays.sort(sorted_queries, (a, b) -> b[0] - a[0]);

        int[] ans = new int[m];
        TreeMap<Integer, Integer> map = new TreeMap();

        int nums_idx = 0;
        for(int[] query : sorted_queries){
            int x = query[0];
            int y = query[1];
            int idx = query[2];
            while(nums_idx < n && sorted_nums[nums_idx][0] >= x){

                insert(map, sorted_nums[nums_idx][0], sorted_nums[nums_idx][1]);
                nums_idx++;
            }

            ans[idx] = map.ceilingKey(y) == null ? -1 : map.get(map.ceilingKey(y));
        }

        return ans;
    }

    public void insert(TreeMap<Integer, Integer> map, int num1, int num2){

        int sum = num1 + num2;
        if(map.containsKey(num2) && map.get(num2) >= sum){
            return;
        }
        Integer greater_than_num2 = map.higherKey(num2);
        if(greater_than_num2 != null && map.get(greater_than_num2) >= sum){
            return;
        }

        Set<Integer> set = new HashSet();
        Integer lower_than_num2 = map.lowerKey(num2);
        while(lower_than_num2 != null){
            if(map.get(lower_than_num2) <= sum) {
                set.add(lower_than_num2);
            } else {
                break;
            }
            lower_than_num2 = map.lowerKey(lower_than_num2);
        }

        for(int lower_num2 : set) map.remove(lower_num2);
        map.put(num2, sum);

    }

    public static void main(String[] args) {
        int[] ans = new MaximumSumQueries().maximumSumQueries(new int[]{4,3,1,2}, new int[]{2,4,9,5}, new int[][]{{4,1}, {1,3}, {2,5}});
        int[] ans2 = new MaximumSumQueries().maximumSumQueries(new int[]{3,2,5}, new int[]{2,3,4}, new int[][]{{4,4}, {3,2}, {1,1}});
        int[] ans3 = new MaximumSumQueries().maximumSumQueries(new int[]{2,1}, new int[]{2,3}, new int[][]{{3,3}});
        int[] ans4 = new MaximumSumQueries().maximumSumQueries(new int[]{31}, new int[]{17}, new int[][]{{1,79}});
        int[] ans5 = new MaximumSumQueries().maximumSumQueries(new int[]{72,44}, new int[]{60,86}, new int[][]{{33,14}});
        int[] ans6 = new MaximumSumQueries().maximumSumQueries(new int[]{13,67,90,92,47}, new int[]{52,60,69,49,73}, new int[][]{{32,70}});
        TreeSet<Integer> ts = new TreeSet();
        ts.higher(1);
        String s = "1.02.003";
        String[] x = s.split("\\.");
        int i = 8;
        int end1 = s.indexOf('.', i);
        if(end1 == -1) {
            end1 = s.length();
        }
        int num1 = Integer.valueOf(s.substring(i, end1 ));
        System.out.println(num1);

    }

}
