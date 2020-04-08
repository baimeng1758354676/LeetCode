package com.honor.week30;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week30
 * @Description:
 * @date: 2020/1/10 14:47
 */
public class LeetCode_226_LG {
    public static void main(String[] args){
        TreeNode p1 = new TreeNode(5);
        p1.left = new TreeNode(4);
        p1.right = new TreeNode(8);
        p1.right.right = new TreeNode(4);
        p1.right.left = new TreeNode(13);
        p1.right.right.right = new TreeNode(1);
        p1.left.left = new TreeNode(11);
        p1.left.left.left = new TreeNode(7);
        p1.left.left.right = new TreeNode(2);
        TreeNode treeNode = invertTree(p1);
        System.out.println("LuoGuang:LeetCode_226_LG.main():");
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 34.2 MB
     * , 在所有 Java 提交中击败了
     * 39.70%
     * 的用户
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode newTree = new TreeNode(root.val);
        newTree.left = right;
        newTree.right = left;
        return newTree;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
