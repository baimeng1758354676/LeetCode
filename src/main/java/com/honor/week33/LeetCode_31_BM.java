package com.honor.week33;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: 白猛
 * @Date: 2020/1/9 17:57
 */
public class LeetCode_31_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 5};
        int[] ints = nextPermutation(nums);
        System.out.println(11);

    }

    public static int[] nextPermutation(int[] nums) {

        //获取所有数字组合
        Set<String> numSet = new TreeSet<>();
        List<String> numbers = new ArrayList<>();
        String numStr = "";
        for (int num : nums) {
            numbers.add(String.valueOf(num));
            numStr += String.valueOf(num);
        }

        getComb(numSet, numbers, "");
        List<String> list = new ArrayList<>(numSet);
        int index = list.indexOf(numStr);
        if (index == -1 || index == list.size() - 1) {
            String s = list.get(0);
            return getIntFromStr(s);
        } else {
            return getIntFromStr(list.get(index + 1));
        }


    }

    private static int[] getIntFromStr(String s) {
        char[] chars = s.toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = Integer.parseInt(chars[i] + "");
        }
        return result;
    }

    private static void getComb(Set<String> numSet, List<String> nums, String i) {
        if (nums.size() < 1) {
            numSet.add(i);
            return;
        }
        for (int j = 0; j < nums.size(); j++) {
            List<String> list = new ArrayList<>(nums);
            list.remove(j);
            getComb(numSet, list, i + nums.get(j));
        }
    }

}
