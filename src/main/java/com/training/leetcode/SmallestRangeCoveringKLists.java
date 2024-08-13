package com.training.leetcode;

import java.util.*;

public class SmallestRangeCoveringKLists {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(nums.get(o1[0]).get(o1[1]), nums.get(o2[0]).get(o2[1]));
            }
        });

        int n = nums.size();
        int min = nums.get(0).get(0);
        int max = nums.get(0).get(0);
        for (int i = 0; i < n; i++) {
            int num = nums.get(i).get(0);
            pq.add(new int[]{i, 0});
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] ans = new int[]{min,max};

        while (!pq.isEmpty()) {
            int[] val = pq.poll();
            int row = val[0];
            int col = val[1];
            if (col + 1 == nums.get(row).size()) break;

            int next = nums.get(row).get(col + 1);
            int range = ans[1] - ans[0];
            min = Math.min(nums.get(pq.peek()[0]).get(pq.peek()[1]), next);
            max = Math.max(max, next);
            int currRange = max - min;
            if(currRange < range || (currRange == range && min < ans[0])){
                ans[0] = min;
                ans[1] = max;
            }

            pq.add(new int[]{row, col + 1});

        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(4, 10, 15, 24, 26));
        list1.add(Arrays.asList(0, 9, 12, 20));
        list1.add(Arrays.asList(5, 18, 22, 30));

        int[] ans = new SmallestRangeCoveringKLists().smallestRange(list1);

        System.out.println(ans[0] + "," + ans[1]);

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(1, 2, 3));
        list2.add(Arrays.asList(1, 2, 3));
        list2.add(Arrays.asList(1, 2, 3));

        int[] ans2 = new SmallestRangeCoveringKLists().smallestRange(list2);

        System.out.println(ans2[0] + "," + ans2[1]);

        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        List<Integer> res = new ArrayList();
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//
//        for(int i = 0; i < nums.length ; i++){
//
//            if(!q.isEmpty() && q.peekFirst() <= i - k){
//                q.pollFirst();
//            }
//            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
//                q.pollLast();
//            }
//            q.addLast(i);
//            if(i >= k - 1) res.add(nums[q.peekFirst()]);
//        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1] );
        for(int i = 0; i < nums.length; i++){

            int left = i - k;
            if(left >= 0){
                pq.remove(left);
            }
            pq.add(i);
            if(pq.size() == k) res.add(nums[pq.peek()]);

        }

        System.out.println(res);
    }
}
