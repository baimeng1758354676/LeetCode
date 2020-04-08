package com.honor.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 白猛
 * @Date: 2020/2/28 17:16
 */
public class LeetCode_51_BM {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] matrix = {{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'}};

        List<List<String>> res = new ArrayList<>();
        //从第一层往下
        backTack(matrix,0,res);
        return res;
    }

    private static void backTack(char[][] matrix, int i,List<List<String>> res) {
        if (i == matrix.length) {
            List<String> strings = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                strings.add(String.valueOf(matrix[j]));
            }
            res.add(strings);
            return;
        }

        //决策
        for (int j = 0; j < matrix.length; j++) {
            //检查
            if (!check(matrix,i,j)) {
                continue;
            }
            //放置皇后
            matrix[i][j] = 'Q';
            backTack(matrix, i + 1,res);
            //撤销
            matrix[i][j] = '.';
        }


    }

    private static boolean check(char[][] matrix, int i, int j) {
        //检查之前行的该列
        for (int k = 0; k < i; k++) {
            if (matrix[k][j] == 'Q') {
                return false;
            }
        }

        //检查左上和右上
        for (int k = 0; k < i; k++) {
            //右上
            if (i - k - 1 >= 0 && j + k + 1 < matrix.length) {
                if (matrix[i - k - 1][j + k + 1] == 'Q') {
                    return false;
                }
            }

            //左上
            if (i - k - 1 >= 0 && j - k - 1 >= 0) {
                if (matrix[i - k - 1][j - k - 1] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }


}
