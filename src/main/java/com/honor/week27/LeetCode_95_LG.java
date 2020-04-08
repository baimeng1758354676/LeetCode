package com.honor.week27;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week27
 * @Description:
 * @date: 2019/12/9 15:47
 */
public class LeetCode_95_LG {


    public static void main(String[] args){
        List<TreeNode> treeNodes = generateTrees(3);
        System.out.println("LuoGuang:LeetCode_95_LG.main():"+treeNodes);
    }
    public static List<TreeNode> generateTrees(int n){
        if (0 == n){
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 java 提交中击败了
     * 96.84%
     * 的用户
     * 内存消耗 :
     * 37.6 MB
     * , 在所有 java 提交中击败了
     * 87.78%
     * 的用户
     * @param start
     * @param end
     * @return
     */
    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end){
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = start; i <= end;  i++){
            List<TreeNode> left = generateTrees(start, i-1);
            List<TreeNode> right = generateTrees(i+1,end);
            for (TreeNode l: left){
                for (TreeNode r: right){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = l;
                    treeNode.right = r;
                    treeNodes.add(treeNode);
                }
            }
        }

        return treeNodes;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
