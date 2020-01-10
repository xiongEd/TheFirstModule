package LeetCode;

import Study.LDR;

import java.util.*;

/*
最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。

给出最大树的根节点 root。

就像之前的问题那样，给定的树是从表 A（root = Construct(A)）递归地使用下述 Construct(A) 例程构造的：

如果 A 为空，返回 null
否则，令 A[i] 作为 A 的最大元素。创建一个值为 A[i] 的根节点 root
root 的左子树将被构建为 Construct([A[0], A[1], ..., A[i-1]])
root 的右子树将被构建为 Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
返回 root
请注意，我们没有直接给定 A，只有一个根节点 root = Construct(A).

假设 B 是 A 的副本，并附加值 val。保证 B 中的值是不同的。

返回 Construct(B)。

 

示例 1：



输入：root = [4,1,3,null,null,2], val = 5
输出：[5,4,null,1,3,null,null,2]
解释：A = [1,4,2,3], B = [1,4,2,3,5]
示例 2：


输入：root = [5,2,4,null,1], val = 3
输出：[5,2,4,null,1,null,3]
解释：A = [2,1,5,4], B = [2,1,5,4,3]
示例 3：


输入：root = [5,2,3,null,1], val = 4
输出：[5,2,4,null,1,3]
解释：A = [2,1,5,3], B = [2,1,5,3,4]
 

提示：

1 <= B.length <= 100
 */
public class Solution998 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> list = inorder(root);
        list.add(val);
        TreeNode res;
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i ++)
            ints[i] = list.get(i);
       res = constructMaximumBinaryTree(ints);
        return res;
    }

    public static List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode cur;
        boolean flag = false;

        while (!stack.empty()){
            cur = stack.peek();

            if (cur.left != null && !flag){
                stack.add(cur.left);
                flag = false;
                continue;
            }

            res.add(cur.val);
            stack.pop();
            if (cur.right != null){
                stack.add(cur.right);
                flag = false;
                continue;
            }

            flag = true;
        }
        return res;
    }

    private TreeNode constructMaximumBinaryTree(int[] nums) {
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
