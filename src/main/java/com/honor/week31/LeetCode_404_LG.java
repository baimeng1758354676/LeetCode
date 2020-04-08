package com.honor.week31;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week31
 * @Description:
 * @date: 2020/1/16 14:27
 */
public class LeetCode_404_LG {
    
    public static void main(String[] args){
        TreeNode p1 = new TreeNode(3);
        p1.left = new TreeNode(9);
        p1.right = new TreeNode(20);
        p1.left.left = new TreeNode(1);
//        p1.right.right = new TreeNode(7);
        System.out.println("LuoGuang:LeetCode_404_LG.main():"+sumOfLeftLeaves(p1));
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 36.4 MB
     * , 在所有 Java 提交中击败了
     * 5.41%
     * 的用户
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (null == root){
            return 0;
        }
        int sum = 0;
        if (null != root.left){
            sum += sumOfLeftLeaves(root.left);
            if (root.left.left == null && null == root.left.right){
                sum += root.left.val;
            }
        }
        if (null != root.right){
            sum += sumOfLeftLeaves(root.right);
        }

        return sum;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
