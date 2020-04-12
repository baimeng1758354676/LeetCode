package com.honor.pre;


import java.util.Arrays;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 白猛
 * @Date: 2020/1/15 10:56
 */
public class LeetCode_37_BM {

    private static boolean solved = false;

    //保存行、列、子数独
    static int[][] rows = new int[9][10];
    static int[][] columns = new int[9][10];
    static int[][] boxes = new int[9][10];
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }


    public static   void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //初始化
                char c = board[i][j];
                int boxIndex = i / 3 * 3 + j / 3;
                if (c != '.') {
                    int num = c - '0';
                    //在对应的索引位置 设置值为1
                    rows[i][num]++;
                    columns[j][num]++;
                    boxes[boxIndex][num]++;

                }
            }
        }

        //开始回溯
        backTack(0, 0,board);

    }

    private static void backTack(int i, int j, char[][] board) {
        int boxIndex = i / 3 * 3 + j / 3;
        if (board[i][j] == '.') {
            //填数字1~9
            for (int k = 1; k <= 9; k++) {
                if (check(i, j, k)) {
                    rows[i][k]++;
                    columns[j][k]++;
                    boxes[boxIndex][k]++;
                    board[i][j] = (char) (k + '0');
                    putNext(i,j,board);
                    if (!solved) {
                        rows[i][k]--;
                        columns[j][k]--;
                        boxes[boxIndex][k]--;
                        board[i][j] = '.';
                    }
                }

            }
        } else {
            putNext(i, j, board);
        }
    }

    private static void putNext(int i, int j, char[][] board) {
        if (i == 8 && j == 8) {
            solved = true;
        } else {
            if (j == 8) {
                backTack(i + 1, 0, board);
            } else {
                backTack(i,j+1,board);
            }
        }
    }

    private static boolean check(int i, int j, int k) {
        //在i j 放置 k
        int boxIndex = i/3*3 +j/3;
        return rows[i][k] == 0 && columns[j][k]== 0 && boxes[boxIndex][k] == 0;
    }


}
