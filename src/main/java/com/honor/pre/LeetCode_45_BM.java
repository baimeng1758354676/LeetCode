package com.honor.pre;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 * @Author: 白猛
 * @Date: 2020/2/27 14:24
 */
public class LeetCode_45_BM {
    private static Integer result;

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,1,1,4};
        int jump = jump(nums);
        System.out.println(jump);

    }
    public static int jump(int[] nums) {
        int index = 0;
        int steps = 0;

        jumpFrom(index,steps,nums);
        return result;
    }

    private static void jumpFrom(int index, int steps, int[] nums) {

        if (index == nums.length - 1) {
            result = (result == null ? steps : (steps < result ? steps :  result));
            return;
        } else if (index > nums.length - 1) {
            return;
        }

        int value = nums[index];
        if (value == 0) {
            return;
        }
        for (int i = 1; i <= value; i++) {
            jumpFrom(index+i,steps+1,nums);
        }
    }

}