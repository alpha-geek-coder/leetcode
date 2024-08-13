package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class Calculator {
    public int calculate(String s) {
//
//        int n = s.length();
//        Stack<Character> stack = new Stack<>();
//        Stack<Integer> sum = new Stack<>();
//        sum.push(0);
//        for(int i = 0; i < n; i++){
//            char c = s.charAt(i);
//            if(c == ' ') continue;
//            stack.push(c);
//            while(stack.size() >= 2 && (stack.get(stack.size() - 2) == '+' || stack.get(stack.size() - 2) == '-')){
//                int operand1 = stack.pop() - '0';
//                char operator = stack.pop();
//                int total = sum.pop();
//
//                int operand2 = c - '0';
//                if(operator == '+'){
//                    total += operand1 + operand2;
//                } else if(operator == '-'){
//                    total += operand1 - operand2;
//                }
//                sum.push(total);
//            }
//        }
//        return sum.pop();
        Map<Character, BiFunction<Integer, Stack<Integer>, Integer>> operations = new HashMap<>();
        operations.put('+', (a,b) -> a );
        operations.put('-', (a,b) -> -a);
        operations.put('*', (a,b) -> a * b.pop());
        operations.put('/', (a,b) -> b.pop() / a);

        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        Stack<Character> groups = new Stack<>();
        int currNumber = 0;
        char operation = '+';
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNumber = currNumber * 10 + (c - '0');
            }
            if(!Character.isDigit(c) && c != ' ' || i == n - 1){
                int res = operations.get(operation).apply(currNumber, stack);
                stack.push(res);
                operation = c;
                currNumber = 0;
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
    public int calculateWithParenthesis(String s){

        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int currNumber = 0, sign = 1, sum = 0;
        char operation = '+';
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currNumber = c - '0';
                while(i + 1 < n && Character.isDigit(s.charAt(i + 1))){
                    currNumber = currNumber * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                sum += currNumber * sign;
            } else if(c == '+'){
                sign = 1;
            } else if(c == '-'){
                sign = -1;
            } else if(c == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }else if(c == ')'){
                sign = stack.pop();
                sum = (sum * sign) + stack.pop();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().calculateWithParenthesis("(1 + 1) "));
    }
}
