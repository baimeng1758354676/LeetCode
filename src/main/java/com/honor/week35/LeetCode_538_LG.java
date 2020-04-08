package com.honor.week35;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week35
 * @Description:
 * @date: 2020/2/21 15:36
 */
public class LeetCode_538_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(5);
        p1.right = new TreeNode(13);
        p1.left = new TreeNode(2);
        TreeNode treeNode = convertBST(p1);
        System.out.println("LuoGuang:LeetCode_538_LG.main():"+treeNode);
    }
    static int sum = 0;

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.66%
     * 的用户
     * 内存消耗 :
     * 40.9 MB
     * , 在所有 Java 提交中击败了
     * 36.26%
     * 的用户
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        if (null == root){
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
