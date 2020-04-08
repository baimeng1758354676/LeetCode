package com.honor.week32;

import java.util.*;

/**
 * @Author: 白猛
 * @Date: 2020/1/9 15:50
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_30_BM {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        String[] words = new String[]{"foo", "bar"};
        List<Integer> barfoothefoobarman = findSubstring("barfoothefoobarman", words);
        System.out.println(1);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        //words的所有组合
        List<Integer> result = new ArrayList<>();
        Set<String> subs = new HashSet<>();
        List<String> strings = Arrays.asList(words);
        findSubSet(subs, strings, "");
        int subLength = words[0].length() * words.length;
        for (int i = 0; i < s.length() - subLength + 1; i++) {
            if (subs.contains(s.substring(i, i + subLength))) {
                result.add(i);
            }
        }
        return result;
    }

    private static void findSubSet(Set<String> subs, List<String> strings, String s) {
        if (strings.size() <= 0) {
            subs.add(s);
            return;
        }
        for (String string : strings) {
            List<String> subStrings = new LinkedList<>(strings);
            subStrings.remove(string);
            findSubSet(subs, subStrings, s + string);
        }

    }
}
