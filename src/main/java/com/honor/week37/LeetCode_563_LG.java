package com.honor.week37;

/**
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例:
 *
 * 输入:
 *          1
 *        /   \
 *       2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 注意:
 *
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week37
 * @Description:
 * @date: 2020/3/2 14:38
 */
public class LeetCode_563_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(1);
        p1.right = new TreeNode(3);
        p1.left = new TreeNode(2);
        p1.left.left = new TreeNode(4);
        System.out.println("LuoGuang:LeetCode_563_LG.main():"+findTilt(p1));
    }

    static int count = 0;
    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 91.61%
     * 的用户
     * 内存消耗 :
     * 40.5 MB
     * , 在所有 Java 提交中击败了
     * 5.26%
     * 的用户户
     * @param root
     * @return
     */
    public static int findTilt(TreeNode root) {
        countTreeVal(root);
        return count;
    }

    private static int countTreeVal(TreeNode root) {
        if (null == root){
            return 0;
        }

        int leftCount = countTreeVal(root.left);
        int rightCount = countTreeVal(root.right);
        count += Math.abs(leftCount - rightCount);
        return root.val + leftCount + rightCount;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
