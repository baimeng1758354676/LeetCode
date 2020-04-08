package com.honor.week25;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week25
 * @Description:
 * @date: 2019/11/28 19:09
 */
public class LeetCode_101_LG {

    public static void main(String[] args){
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        p.right = new TreeNode(1);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(3);
        p.right.right = new TreeNode(3);
        p.right.left = new TreeNode(2);

        System.out.println("LuoGuang:LeetCode_101_LG.main():"+isSymmetric(p));
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 39.5 MB
     * , 在所有 java 提交中击败了
     * 40.74%
     * 的用户
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return symmetric(root.left, root.right);

    }

    private static boolean symmetric(TreeNode left, TreeNode right) {
        if (null == left && null == right){
            return true;
        }
        if (null == left || null == right){
            return false;
        }

        if (left.val != right.val){
            return false;
        }
        return symmetric(left.left, right.right) && symmetric(left.right,right.left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
