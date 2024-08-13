package com.training.leetcode;


import java.util.Arrays;



class SortJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mapped = new int[n][2];


        for(int i = 0; i < n; i++){
            int unit = 1;
            int num = nums[i];
            int mapped_value = 0;
            if(num == 0) mapped_value = mapping[num];
            while(num > 0){
                mapped_value = mapped_value + mapping[num % 10] * unit;
                num /= 10;
                unit *= 10;
            }
            mapped[i][0] = mapped_value;
            mapped[i][1] = i;
        }

        Arrays.sort(mapped, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = nums[mapped[i][1]];
        }

        return ans;
    }

    public static void main(String[] args){
        int[] ans = new SortJumbledNumbers().sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[] {0,1,2,3,4,5,6,7,8,9});
    //     Map<Integer, Integer> map = new HashMap();
    //   //  Pair<Integer, Integer> pair = new Pair(2, 2);

    //     map.put(1,1);
    //     for(int val : map.values()){
    //         System.out.println(val);
    //         System.out.println(pair.getValue());
    //     }
    }
}