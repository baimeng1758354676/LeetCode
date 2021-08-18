package com.honor.pre;


/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 白猛
 * @Date: 2020/1/16 17:02
 */
public class LeetCode_41_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        int i = firstMissingPositive(nums);
        System.out.println(1);
    }
    public static int firstMissingPositive(int[] nums) {
        //抽屉原理
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <=len && nums[nums[i] - 1] != nums[i]) {
                swapNum(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;

    }

    private static void swapNum(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
