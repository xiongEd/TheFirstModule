package LeetCode;
/*
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
 */
public class Solution124 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        function(root);
        return maxValue;
    }

    private int function(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = root.val, left, right;
        left = Math.max(function(root.left), 0);
        right = Math.max(function(root.right), 0);
        result += Math.max(left, right);
        maxValue = Math.max(maxValue, root.val + left + right);
        maxValue = Math.max(maxValue, result);
        return result;
    }
}
