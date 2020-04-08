package com.honor.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @Author: 白猛
 * @Date: 2020/2/27 16:35
 */
public class LeetCode_46_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3,4};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        backTack(res,new ArrayList<Integer>(),numbers);
        return res;
    }

    private static void backTack(List<List<Integer>> res, List<Integer> integers, List<Integer> numbers) {
        if (numbers.size() == 0) {
            res.add(integers);
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> numbers1 = new ArrayList<>(numbers);
            numbers1.remove(i);
            List<Integer> integers1 = new ArrayList<>(integers);
            integers1.add(numbers.get(i));
            backTack(res,integers1,numbers1);
        }
    }
}
