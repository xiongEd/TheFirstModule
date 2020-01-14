package LeetCode;

import java.util.*;

/*
序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

编码的字符串应尽可能紧凑。

注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */
public class Solution449 {
        public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return "";
        stack.add(root);
        TreeNode cur;
        while (!stack.empty()){
            cur = stack.pop();
            res.append(cur.val);
            res.append('#');
            if (cur.right != null){
                stack.add(cur.right);
            }

            if (cur.left != null){
                stack.add(cur.left);
            }
        }
        return res.toString();
    }

    TreeNode deserialize(String str) {
        if (str.length() == 0) return null;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int temp = 0;
        char[]chars = str.toCharArray();

        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                temp = temp * 10 + (aChar - '0');
            } else if (aChar == '#') {
                arrayList.add(temp);
                temp = 0;
            }
        }

        int[]a = new int[arrayList.size()];
        for (int i = 0; i < a.length; i ++){
            a[i] = arrayList.get(i);
        }

        return GetTree(a,0, a.length - 1);
    }

    private TreeNode GetTree(int[] ints, int i, int j){
            if (i > j)
                return null;
        TreeNode res = new TreeNode(ints[i]);
        int m;
        for (m = i + 1; m <= j; m ++){
            if (ints[m] > ints[i]){
                res.right = GetTree(ints, m, j);
                break;
            }
        }
        if (m > i + 1 && j > i){
            res.left = GetTree(ints, i + 1, m -1);
        }
        return res;
    }
}
