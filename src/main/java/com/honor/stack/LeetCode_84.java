package com.honor.stack;

import java.util.Stack;

/**
 * 柱状图中的最大矩形
 *
 * @Author: 白猛
 * @Date: 2020/4/15 12:31
 */
public class LeetCode_84 {
    private static int largestRectangleArea(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            while (stack.peek() != -1 && nums[stack.peek()] > nums[i]) {
                max = Math.max(max, nums[stack.pop()] * (i - stack.peek() - 1));

            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, nums[stack.pop()] * (nums.length - stack.peek()));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 5, 6, 2, 3};
        int i = largestRectangleArea(nums);
        System.out.println(i);
    }
}
