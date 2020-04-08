package com.honor.week31;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week31
 * @Description:
 * @date: 2020/1/13 14:17
 */
public class LeetCode_235_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(6);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(8);
        p1.right.right = new TreeNode(9);
        p1.right.left = new TreeNode(7);
        p1.left.left = new TreeNode(0);
        p1.left.right = new TreeNode(4);
        p1.left.right.left = new TreeNode(3);
        p1.left.right.right = new TreeNode(5);
        TreeNode treeNode = lowestCommonAncestor(p1, new TreeNode(3), new TreeNode(5));
        System.out.println("LuoGuang:LeetCode_235_LG.main():"+treeNode);
    }

    /**
     * 执行用时 :
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 99.52%
     * 的用户
     * 内存消耗 :
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 79.70%
     * 的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        if (root.val < Math.max(p.val,q.val) && root.val > Math.min(p.val,q.val)){
            return root;
        }
        if (root.val > p.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right, p, q);


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
