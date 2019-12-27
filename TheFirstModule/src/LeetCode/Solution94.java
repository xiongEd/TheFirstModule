package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution94 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>res = new ArrayList<Integer>();
        if (root == null)
            return res;
        SolveFunction(root,res);
        return res;
    }

    public void SolveFunction(TreeNode root, List<Integer> res){
        if(root.left != null) SolveFunction(root.left, res);
        res.add(root.val);
        if(root.right != null) SolveFunction(root.right, res);
    }
}
