package com.honor.pre;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * @Author: 白猛
 * @Date: 2020/2/27 17:19
 */
public class LeetCode_47_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {

        int len = nums.length;
        boolean[] used = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        Arrays.sort(nums);
        dfs(nums,path,used,res,0);
        return res;
    }

    private static void dfs(int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> res, int depth) {

        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i]&&!used[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, path, used, res, depth + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
