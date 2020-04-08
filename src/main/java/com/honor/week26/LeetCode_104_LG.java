package com.honor.week26;

/**
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week26
 * @Description:
 * @date: 2019/12/2 19:44
 */
public class LeetCode_104_LG {
    public static void main(String[] args){
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        p.right = new TreeNode(1);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(3);
        p.right.right = new TreeNode(3);
        p.right.left = new TreeNode(2);
        p.left.right.left = new TreeNode(5);

        System.out.println("LuoGuang:LeetCode_104_LG.main():"+maxDepth(p));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 71.87%
     * 的用户
     * 内存消耗 :
     * 37.6 MB
     * , 在所有 java 提交中击败了
     * 42.28%
     * 的用户
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        int depth =  sumMaxDepth(root, 0);
        return depth;
    }

    private static int sumMaxDepth(TreeNode root, int depth) {
        if (root == null){
            return depth;
        }

        int left = sumMaxDepth(root.left, depth + 1);

        int right = sumMaxDepth(root.right, depth + 1);

        return Math.max(left, right);
    }
}
