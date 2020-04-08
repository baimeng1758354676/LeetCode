package com.honor.week28;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week28
 * @Description:
 * @date: 2019/12/21 15:51
 */
public class LeetCode_96_LG {



    public static void main(String[] args){
        int num = numTrees(3);
        System.out.println("LuoGuang:LeetCode_96_LG.main():"+num);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 32.8 MB
     * , 在所有 java 提交中击败了
     * 12.58%
     * 的用户
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int G[] = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i;j++){
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
