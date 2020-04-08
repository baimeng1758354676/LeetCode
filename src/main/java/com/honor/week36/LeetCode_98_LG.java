package com.honor.week36;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week36
 * @Description:
 * @date: 2020/2/25 17:12
 */
public class LeetCode_98_LG {


    public static void main(String[] args){
        TreeNode p1 = new TreeNode(2);
        p1.right = new TreeNode(3);
        p1.left = new TreeNode(1);
        System.out.println("LuoGuang:LeetCode_98_LG.main():"+isValidBST(p1));
    }
    static Integer before = null;

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 40.7 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (null == root){
            return true;
        }
        boolean left = isValidBST(root.left);
        if (before == null){
            before = root.val;
        }else {
            if (before >= root.val){
                return false;
            }
            before = root.val;
        }
        boolean right = isValidBST(root.right);

        return left && right;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
