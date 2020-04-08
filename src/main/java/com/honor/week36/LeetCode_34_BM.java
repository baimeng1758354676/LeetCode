package com.honor.week36;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: 白猛
 * @Date: 2020/1/14 15:08
 */
public class LeetCode_34_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 6);
        System.out.println(1);
    }

    public static int[] searchRange(int[] nums, int target) {
        //先找开始位置
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[]{-1, -1};
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return findRange(nums, mid);
            } else if (target < nums[mid] && target >= nums[left]) {
                //前半段
                right = mid - 1;
            } else if (target > nums[mid] && target <= nums[right]) {
                //后半段
                left = mid + 1;
            } else {
                return result;
            }
        }
        return result;
    }

    private static int[] findRange(int[] nums, int mid) {
        int lelfRange = mid, rightRange = mid;
        while (lelfRange > 0 && nums[lelfRange - 1] == nums[lelfRange]) {
            lelfRange--;
        }

        while (rightRange < nums.length - 1 && nums[rightRange + 1] == nums[rightRange]) {
            rightRange++;
        }
        return new int[]{lelfRange, rightRange};
    }
}
