package com.honor.week35;

/**
 * @Author: 白猛
 * @Date: 2020/1/14 10:45
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_33_BM {
    public static void main(String[] args) {
        int[] numss = new int[]{3, 1};
        int search = search(numss, 1);
        System.out.println(1);
    }

    public static int search(int[] nums, int target) {
        //二分法
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        if (left == right) {
            return nums[0] == target ? 0 : -1;
        }
        while (left <= right) {
            int index = (left + right) / 2;
            if (target == nums[index]) {
                return index;
            } else if (nums[index] >= nums[left]) {
                if (target >= nums[left] && target < nums[index]) {
                    right = index - 1;
                } else {
                    left = index + 1;
                }


            } else {
                if (target > nums[index] && target <= nums[right]) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }

            }
        }
        return result;
    }
}
