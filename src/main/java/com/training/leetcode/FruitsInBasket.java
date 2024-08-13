package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {
    public int totalFruit(int[] fruits) {

        int max = 0;
//        for(int left = 0; left < fruits.length; left++){
//            Set<Integer> baskets = new HashSet<>();
//            int right = left;
//
//            while(right < fruits.length){
//
//                if(!baskets.contains(fruits[right]) && baskets.size() == 2){
//                    break;
//                }
//                baskets.add(fruits[right]);
//                right++;
//            }
//            max = Math.max(max, right - left);
//        }
        Map<Integer, Integer> baskets = new HashMap<>();
        int left = 0, right = 0;

        for(; right < fruits.length; right++){

            int type = fruits[right];
            baskets.put(type, baskets.getOrDefault(type, 0) + 1);

            while(baskets.size() > 2){
                baskets.put(fruits[left], baskets.get(fruits[left]) - 1);
                if(baskets.get(fruits[left]) == 0) {
                    baskets.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new FruitsInBasket().totalFruit(new int[] {1,2,1}));
        System.out.println(new FruitsInBasket().totalFruit(new int[] {0,1,2,2}));
        System.out.println(new FruitsInBasket().totalFruit(new int[] {1,2,3,2,2}));
        System.out.println(new FruitsInBasket().totalFruit(new int[] {1,0,1,4,1,4,1,2,3}));

    }
}
