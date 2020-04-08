package com.honor.week32;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week32
 * @Description:
 * @date: 2020/1/17 15:21
 */
public class LeetCode_437_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(-2);
        p1.right = new TreeNode(-3);
        p1.right.left = new TreeNode(-2);
        p1.left.left = new TreeNode(1);
        p1.left.right = new TreeNode(3);
        p1.left.left.left = new TreeNode(-1);
        System.out.println("LuoGuang:LeetCode_437_LG.main():"+pathSum(p1,3));
    }



    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return paths(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    /**
     * 执行用时 :
     * 16 ms
     * , 在所有 Java 提交中击败了
     * 74.84%
     * 的用户
     * 内存消耗 :
     * 40.9 MB
     * , 在所有 Java 提交中击败了
     * 14.96%
     * 的用户
     * @param root
     * @param last
     * @return
     */
    private static int paths(TreeNode root, int last) {

        if (root == null){
            return 0;
        }

        last -= root.val;

        int res = 0;
        if (last == 0){
            res = 1;
        }
        return res + paths(root.left,last) + paths(root.right,last);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
