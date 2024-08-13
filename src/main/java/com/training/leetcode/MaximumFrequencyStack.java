package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> freqGroups;
    int maxFreq;

    public MaximumFrequencyStack() {
        freq = new HashMap();
        freqGroups = new HashMap<>();
        maxFreq = 0;

    }

    public void push(int val) {
        int valFreq =  freq.getOrDefault(val, 0) + 1;
        freq.put(val, valFreq);
        maxFreq = Math.max(maxFreq, valFreq);
        freqGroups.computeIfAbsent(valFreq, v-> new Stack<>()).push(val);
    }

    public int pop() {
        int val = freqGroups.get(maxFreq).pop();
        freq.put(val, freq.get(val) - 1);
        if(freqGroups.get(maxFreq).size() == 0){
            maxFreq--;
        }

        return val;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack freqStack = new MaximumFrequencyStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());

        int x = -2, y = -1;
        System.out.println(x + y);

    }
}
