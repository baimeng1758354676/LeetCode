package com.honor.pre;

/**
 * @Author: 白猛
 * @Date: 2020/1/10 17:09
 */
public class StepFloor {
    public static void main(String[] args) {
        int i = climbStairs(4);
        System.out.println(1);
    }

    public  static int climbStairs(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
