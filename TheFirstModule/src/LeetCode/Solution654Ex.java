package LeetCode;

import java.nio.DoubleBuffer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/*
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。

 

示例 ：

输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
 

提示：

给定的数组的大小在 [1, 1000] 之间。
 */
public class Solution654Ex {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return SolveFunction(nums, 0, nums.length - 1);
    }

    public TreeNode SolveFunction(int[] nums, int begin, int end){
        TreeNode res;
        int max = begin;
        for (int i = begin + 1; i <= end; i ++){
            if (nums[i] > nums[max]){
                max = i;
            }
        }
        res = new TreeNode(nums[max]);
        if (max > begin){
            res.left = SolveFunction(nums, begin, max - 1);
        }
        if (max < end){
            res.right = SolveFunction(nums, max + 1, end);
        }

        return res;
    }
}
