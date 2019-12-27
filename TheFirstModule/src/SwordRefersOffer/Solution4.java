package SwordRefersOffer;
import java.util.Arrays;

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class Solution4 {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0)
            return null;
        TreeNode res = new TreeNode(pre[0]);
        SolveFunction(res, pre, in);
        return res;
    };

    public static void SolveFunction(TreeNode res, int[] pre, int[] in){
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

    };

    public static int find(int[]ret, int target){
        int count = 0;
        while(ret[count] != target && count < ret.length){
            count ++;
        }
        if(count == ret.length)
            return -1;
        return count;
    };

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
