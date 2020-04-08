package com.honor.week30;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week30
 * @Description:
 * @date: 2020/1/8 14:31
 */
public class LeetCode_109_LG {
    
    public static void main(String[] args){
        TreeNode p1 = new TreeNode(3);
        p1.left = new TreeNode(9);
        p1.right = new TreeNode(20);
        p1.right.right = new TreeNode(7);
        p1.right.left = new TreeNode(15);
        p1.right.right.left = new TreeNode(3);
        System.out.println("LuoGuang:LeetCode_109_LG.main():"+isBalanced(p1));
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 37.6 MB
     * , 在所有 Java 提交中击败了
     * 56.71%
     * 的用户
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }


        int leftDepth = getMaxDepth(root.left,0);
        int rightDepth = getMaxDepth(root.right,0);
        int reduction = leftDepth - rightDepth;
        if (reduction > 1 || reduction < -1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getMaxDepth(TreeNode treeNode,int index){
        if (treeNode == null){
            return index;
        }
        index++;
        return Math.max(getMaxDepth(treeNode.left,index),getMaxDepth(treeNode.right,index));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
