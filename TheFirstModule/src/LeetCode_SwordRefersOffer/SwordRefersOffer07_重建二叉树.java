package LeetCode_SwordRefersOffer;

import java.util.Arrays;

/*
Solution105
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 

限制：

0 <= 节点个数 <= 5000
 */
public class SwordRefersOffer07_重建二叉树 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public  TreeNode buildTree(int [] preorder,int [] inorder) {
        if(preorder.length == 0)
            return null;
        TreeNode res = new TreeNode(preorder[0]);
        SolveFunction(res, preorder, inorder);
        return res;
    }

    public  void SolveFunction(TreeNode res, int[] pre, int[] in){
        int temp = find(in, res.val);
        if(temp > 0) {
            res.left = new TreeNode(pre[1]);
            if(temp != 1){
                SolveFunction(res.left, Arrays.copyOfRange(pre, 1, temp + 1), Arrays.copyOf(in, temp));
            }
        }
        if(temp < in.length - 1){
            res.right = new TreeNode(pre[temp + 1]);
            if(temp != in.length - 2) {
                SolveFunction(res.right, Arrays.copyOfRange(pre, temp + 1, pre.length), Arrays.copyOfRange(in, temp + 1, pre.length));
            }
        }

    }

    public int find(int[]ret, int target){
        int count = 0;
        while(ret[count] != target && count < ret.length){
            count ++;
        }
        if(count == ret.length)
            return -1;
        return count;
    }
}
