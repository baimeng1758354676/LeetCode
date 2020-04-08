package com.honor.pre;

import cn.hutool.core.util.StrUtil;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 白猛
 * @Date: 2020/1/17 16:39
 */
public class LeetCode_43_BM {
    public static void main(String[] args) {
        String s = multiply("123", "456");
        System.out.println(s);
//        String s = strPlus("1368", "9132");
//        System.out.println(s);

    }
    public static String multiply(String num1, String num2) {
        String result = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            //num2的每一位分别与num1相乘
            StringBuilder builder = new StringBuilder();
            //结果补零
            for (int k = 0; k < num2.length() - 1 - i; k++) {
                builder.append(0);
            }
            //转换成数字
            int first = num1.charAt(i) - '0';

            int temp = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                //乘积
                int product = first * (num2.charAt(j) - '0');
                //
                int sum = temp + product % 10;
                builder.append( sum % 10);
                temp = product / 10 + sum / 10;
            }

            builder.append(temp);
            builder.reverse();
            result = strPlus(builder.toString(), result);

        }
        return result;

    }

    private static String strPlus(String builder, String result) {
        if (StrUtil.isBlank(result)) {
            return builder;
        } else if (StrUtil.isBlank(builder)) {
            return result;
        }
        int builderIndex = builder.length() - 1;
        int resultIndex = result.length() - 1;
        int temp = 0;
        StringBuilder sumStr = new StringBuilder();
        while (builderIndex >= 0 || resultIndex >= 0) {
            int sum = (builderIndex >= 0? builder.charAt(builderIndex) - '0':0) + (resultIndex >= 0? result.charAt(resultIndex) - '0':0);
            int sum2 = temp + sum % 10;
            sumStr.append( sum2 % 10);
            temp = sum / 10 + sum2 / 10;
            builderIndex--;
            resultIndex--;
        }
        if (temp > 0) {
            sumStr.append(temp);
        }
       return sumStr.reverse().toString();
    }
}
