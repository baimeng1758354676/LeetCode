package com.honor.week34;

/**
 *
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 *
 * 示例 :
 *
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 *
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 注意: 树中至少有2个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week34
 * @Description:
 * @date: 2020/2/13 14:25
 */
public class LeetCode_530_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(543);
        p1.right = new TreeNode(652);
        p1.right.right = new TreeNode(699);
        p1.left = new TreeNode(384);
        p1.left.right = new TreeNode(445);
        System.out.println("LuoGuang:LeetCode_501_LG.main():"+getMinimumDifference(p1));
    }

    static TreeNode preNum = null;
    static int min = Integer.MAX_VALUE;

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 52.1 MB
     * , 在所有 Java 提交中击败了
     * 5.05%
     * 的用户
     * @param root
     * @return
     */
    public static int getMinimumDifference(TreeNode root) {
        if (null == root){
            return Integer.MAX_VALUE;
        }
        getMinimumDifference(root.left);

        if (null != preNum){
            min = Math.min(min,root.val - preNum.val);
        }
        preNum = root;
        System.out.println("LuoGuang:LeetCode_530_LG.getMinimumDifference():"+root.val);

        getMinimumDifference(root.right);
        return min;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
