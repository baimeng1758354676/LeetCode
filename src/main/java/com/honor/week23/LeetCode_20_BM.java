package com.honor.week23;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 执行结果：
 * 通过
 * 显示详情
 * <p>
 * 执行用时 :
 * 3 ms
 * , 在所有 java 提交中击败了
 * 84.33%
 * 的用户
 * 内存消耗 :
 * 34.4 MB
 * , 在所有 java 提交中击败了
 * 84.27%
 * 的用户
 *
 * @Author: 白猛
 * @Date: 2019/11/9 11:19
 */
public class LeetCode_20_BM {


    public static void main(String[] args) {
        String s = new String("{}");
        boolean valid = isValid(s);
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.empty() || map.containsKey(ch)) {
                stack.push(ch);
            } else {
                Character pop = stack.pop();
                if (!map.containsKey(pop) || !map.get(pop).equals(ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
