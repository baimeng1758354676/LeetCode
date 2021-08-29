package com.honor.xiaohaoalgorithm;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @program: cloud-integration
 * @description:
 * @Author: baimeng
 * @Date: 2021/8/29 10:45
 */
public class PlusOne {
    public static void main(String[] args) {

        PlusOne plusOne = new PlusOne();
        int[] a = new int[]{9, 9, 9};

        int[] result = plusOne.plusOne(a);

        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] a) {
        //进位
        boolean flag = false;
        //后往前遍历
        for (int i = a.length - 1; i >= 0; i--) {
            int one = i == a.length - 1 ? 1 : 0;
            if (flag) {
                int sum = a[i] + 1 + one;
                if (sum > 9) {
                    a[i] = sum % 10;
                    flag = true;
                } else {
                    flag = false;
                    a[i] = sum;
                }
            } else {
                int sum = a[i] + one;
                if (sum > 9) {
                    a[i] = sum % 10;
                    flag = true;
                } else {
                    flag = false;
                    a[i] = sum;
                }

            }
        }

        if (flag) {
            int[] result = new int[a.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = a[i - 1];
            }

            return result;

        }


        return a;


    }
}
