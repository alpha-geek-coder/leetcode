package com.training.leetcode;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();

        for(int asteroid : asteroids){
            boolean flag = true;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){

                if(Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                    continue;
                } else if(Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
                flag = false;
                break;
            }
            if(flag){
                stack.push(asteroid);
            }
        }

        int[] ans = new int[stack.size()];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new AsteroidCollision().asteroidCollision(new int[]{8,-8});
        System.out.print("[");
        for(int n : ans){
            System.out.print(n + ",");
        }
        System.out.print("]");
    }
}
