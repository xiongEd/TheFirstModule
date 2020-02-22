package LeetCode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Solution101 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList<>();
        TreeNode q1, q2;
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            q1 = queue.poll();
            q2 = queue.poll();
            if (q1 == null && q2 == null) continue;
            if (q1 == null || q2 == null) return false;
            if (q1.val != q2.val) return false;
            queue.add(q1.left);
            queue.add(q2.right);
            queue.add(q1.right);
            queue.add(q2.left);
        }
        return true;
    }
}
