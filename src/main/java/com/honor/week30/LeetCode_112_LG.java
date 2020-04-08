package com.honor.week30;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week30
 * @Description:
 * @date: 2020/1/10 14:28
 */
public class LeetCode_112_LG {

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
        System.out.println("LuoGuang:LeetCode_112_LG.main():"+hasPathSum(p1,22));
    }


    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 50.77%
     * 的用户
     * 内存消耗 :
     * 37.7 MB
     * , 在所有 Java 提交中击败了
     * 48.59%
     * 的用户
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0){
            return true;
        }
        return hasPathSum(root.left,sum) ||
                hasPathSum(root.right,sum);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
