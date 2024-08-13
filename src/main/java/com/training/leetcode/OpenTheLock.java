package com.training.leetcode;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
//        Map<Character, Character> prev = Map.of(
//                '0', '9',
//                '1', '0',
//                '2', '1',
//                '3', '2',
//                '4', '3',
//                '5', '4',
//                '6', '5',
//                '7', '6',
//                '8', '7',
//                '9', '8'
//        );
//        Map<Character, Character> next = Map.of(
//                '0', '1',
//                '1', '2',
//                '2', '3',
//                '3', '4',
//                '4', '5',
//                '5', '6',
//                '6', '7',
//                '7', '8',
//                '8', '9',
//                '9', '0'
//        );

        Map<Character, Character> prev = new HashMap<>();
        Map<Character, Character> next = new HashMap<>();


        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>(Arrays.asList(deadends));
        q.add("0000");
        seen.add("0000");
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(curr == target) return level;
                for(int idx = 0; idx < 4; idx++){
                    StringBuilder next_combination = new StringBuilder(curr);
                    next_combination.setCharAt(idx, next.get(next_combination.charAt(idx)));
                    StringBuilder prev_combination = new StringBuilder(curr);
                    prev_combination.setCharAt(idx, prev.get(prev_combination.charAt(idx)));
                    if(!seen.contains(next_combination.toString())){
                        q.add(next_combination.toString());
                        seen.add(next_combination.toString());
                    }
                    if(!seen.contains(prev_combination.toString())){
                        q.add(prev_combination.toString());
                        seen.add(prev_combination.toString());
                    }
                }

            }
            level++;
        }
        return -1;
    }
}
