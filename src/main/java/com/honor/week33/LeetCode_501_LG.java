package com.honor.week33;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week33
 * @Description:
 * @date: 2020/2/4 16:50
 */
public class LeetCode_501_LG {

    private static int max = 0;

    private static Integer pre = 1;

    private static Integer val;

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(1);
        p1.right = new TreeNode(2);
        p1.right.left = new TreeNode(2);
        int[] mode = findMode(p1);
        System.out.println("LuoGuang:LeetCode_501_LG.main():"+mode);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.88%
     * 的用户
     * 内存消耗 :
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 78.32%
     * 的用户
     * @param root
     * @return
     */
    public static int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ldr(root, result);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }

    private static void ldr(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        ldr(root.left, result);
        if (val != null){
           if (val == root.val){
               pre++;
           }else {
               pre = 1;
           }
        }
        if (pre == max){
            result.add(root.val);
        }else if (pre > max){
            result.clear();
            result.add(root.val);
            max = pre;
        }

        val = root.val;
        ldr(root.right, result);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
