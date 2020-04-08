package com.honor.week31;

import java.util.HashMap;

/**
 * @Author: 白猛
 * @Date: 2019/12/9 19:06
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * <p>
 * 说明:
 * <p>
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_29_BM {

    static int result = 0;

    public static void main(String[] args) {

        int i = divide(81, 9);
        System.out.println(i);
        HashMap<Object, Object> map = new HashMap<Object, Object>();


    }

    public static int divide(int dividend, int divisor) {
        return recursive(dividend, divisor);
    }

    private static int recursive(int dividend, int divisor) {
        if (Math.abs(dividend) < Math.abs(divisor)) {
            if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (dividend >= 0 && divisor >= 0) || (dividend <= 0 && divisor <= 0) ? result : -result;
        }
        result++;
        if (dividend > 0) {
            return recursive(dividend - Math.abs(divisor), divisor);
        } else {
            return recursive(-(Math.abs(dividend) - Math.abs(divisor)), divisor);
        }

    }
}
