package com.training.leetcode;

import java.util.ArrayDeque;
import java.util.Stack;

public class StockSpanner {
    Stack<Integer[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while(!stack.isEmpty() && stack.peek()[0].intValue() <= price){
            ans += stack.pop()[1];
        }
        stack.push(new Integer[]{price, ans});
        return ans;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
        System.out.println(stockSpanner.next(90));

        ArrayDeque<Integer> result = new ArrayDeque<>();
        result.add(-4);
        result.add(-2);
        result.add(-5);
        System.out.println(result.peekFirst());

    }
}
