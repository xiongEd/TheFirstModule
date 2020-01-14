package LeetCode;

import java.util.ArrayDeque;
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
public class Solution654 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return SolveFunction(nums, 0, nums.length - 1);
    }

    public static TreeNode SolveFunction(int[] nums, int begin, int end){
        TreeNode res;
        Stack<Integer> right = new Stack<Integer>();
        Stack<Integer> left = new Stack<Integer>();

        if (end == begin) return new TreeNode(nums[end]);


        for (int i = begin; i <= end; i ++){
            if (i == begin){
                right.add(i);
                continue;
            }
            if (nums[i] > nums[right.peek()]){
                right.add(i);
            }
        }

        for (int i = end; i > right.peek(); i--){
            if (i == end){
                left.add(i);
                continue;
            }
            if (nums[i] > nums[left.peek()]){
                left.add(i);
            }
        }

        int root = right.pop(), last = root;
        res = new TreeNode(nums[root]);
        TreeNode next = res;
        int leaf;
        while (!right.empty()){
            leaf = right.pop();
            next.left = new TreeNode(nums[leaf]);
            next = next.left;
            if (last - leaf > 1)
                next.right = SolveFunction(nums, leaf + 1, last - 1);
            last = leaf;
        }

        next = res;
        last = root;
        while (!left.empty()){
            leaf = left.pop();
            next.right = new TreeNode(nums[leaf]);
            next = next.right;
            if (leaf - last > 1)
                next.left = SolveFunction(nums, last + 1, leaf - 1);
            last = leaf;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,7,6,9,4,5,13,4,8,2,1};
        TreeNode res = constructMaximumBinaryTree(a);
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(res);
        TreeNode next;
        while (!queue.isEmpty()){
            next = queue.poll();
            System.out.print(next.val + "  ");
            if (next.left != null)
                queue.add(next.left);
           // else System.out.print(null + "  ");
            if (next.right != null)
                queue.add(next.right);
           // else System.out.print(null + "  ");

        }
    }
}
