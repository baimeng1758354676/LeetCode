package com.honor.week37;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: 白猛
 * @Date: 2020/1/14 15:58
 */
public class LeetCode_35_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int i = searchInsert(nums, 7);
        System.out.println(1);
    }

    public static int searchInsert(int[] nums, int target) {
        //二分查找
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (left == right || left == right - 1 && target != nums[mid]) {
                if (target < Math.min(nums[left], nums[right])) {
                    return left;
                } else if (target > Math.max(nums[left], nums[right])) {

                    return right + 1;
                } else {
                    return right;
                }
            }
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid;
            }

        }

        return 0;
    }
}
