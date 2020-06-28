package LeetCode;
/*

根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
通过次数81,819提交次数122,079
 */
public class Solution105 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1)
            return null;
        return SolveFunction(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode SolveFunction(int[] preorder, int[] inorder, int head1, int tail1, int head2, int tail2) {
        if (tail1 < head1 || tail2 < head2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[head1]);
        for (int i = head2; i <= tail2; i ++) {
            if (preorder[head1] == inorder[i]) {
                ;
                if (i > head2) {
                    root.left = SolveFunction(preorder, inorder, head1 + 1, head1 + i - head2, head2, i - 1);
                }
                if (i < tail2) {
                    root.right = SolveFunction(preorder, inorder, head1 + i - head2 + 1, tail1, i + 1, tail2);
                }
            }
        }
        return root;
    }
}
