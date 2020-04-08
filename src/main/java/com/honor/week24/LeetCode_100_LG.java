package com.honor.week24;

import org.apache.commons.lang.StringUtils;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week24
 * @Description:
 * @date: 2019/11/23 14:43
 */
public class LeetCode_100_LG {
    
    public static void main(String[] args){  

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(1);
        System.out.println("LuoGuang:LeetCode_100_LG.main():"+isSameTree2(p,q));
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 34.11%
     * 的用户
     * 内存消耗 :
     * 35.8 MB
     * , 在所有 java 提交中击败了
     * 35.89%
     * 的用户
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        String p1 = dlr(p,"",1);
        String p2 = dlr(q,"",1);

        return StringUtils.equals(p1,p2);
    }

    private static String dlr(TreeNode p, String s, Integer tag) {
        if (p == null){
            return s+tag;
        }
        s = dlr(p.left, s,2);
        s = s + p.val;
        s = dlr(p.right, s,3);
        return s;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 34.1 MB
     * , 在所有 java 提交中击败了
     * 85.52%
     * 的用户
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree2(TreeNode p, TreeNode q) {

        if (p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        return isSameTree2(p.left,q.left) &&
                isSameTree2(p.right,q.right);
    }
}
