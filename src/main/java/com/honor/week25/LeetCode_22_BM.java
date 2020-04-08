package com.honor.week25;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: 白猛
 * @Date: 2019/11/1 17:16
 */
public class LeetCode_22_BM {
    public static void main(String[] args) {

        List<String> strings = generateParenthesis(3);

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        back(result, "", 0, 0, n);
        return result;
    }

    private static void back(List<String> result, String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }

        if (left < n) {
            back(result, s + "(", left + 1, right, n);
        }

        if (right < left) {
            back(result, s + ")", left, right + 1, n);
        }
    }

}
