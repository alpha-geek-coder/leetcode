package com.training.leetcode;

import javafx.util.Pair;

import java.util.*;

public class MaxTotalImportanceOfRoads {

    public long maximumImportance(int n, int[][] roads) {
        int[] indegree = new int[n];

        for(int[] edge : roads){
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for(int i = 0; i < n; i++){
            pq.add(new int[] {i, indegree[i]});
        }

        int[] values = new int[n];
        int value = 1;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            values[curr[0]] = value++;
        }

        int ans = 0;
        for(int[] edge : roads){
            ans += values[edge[0]] + values[edge[1]];
        }
        Arrays.sort(roads);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxTotalImportanceOfRoads().maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}} ));
        List<Integer> ans = new ArrayList();
        ans.toArray();

//        String[] logs = new String[]{"d1/","d2/","../","d21/","./"};
//        Stack<Integer> stack = new Stack();
//        for(int i = 0; i < logs.length; i++){
//            if(logs[i].equals("../")){
//                if(!stack.isEmpty()) stack.pop();
//            } else if(!logs[i].equals("./")){
//                stack.push(i);
//            }
//
//        }
        String s = "(ed(et(oc))el)";
        Stack<Character> stack = new Stack();
        StringBuilder reverse = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c != ')') {
                stack.push(c);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() != '('){
                reverse.append(stack.pop());
            }
            stack.pop();
            for(int i = 0; i < reverse.length(); i++){
                stack.push(reverse.charAt(i));
            }
            reverse.setLength(0);

        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());
        Pair<Integer, Integer> pair = new Pair(2,2);

    }
}
