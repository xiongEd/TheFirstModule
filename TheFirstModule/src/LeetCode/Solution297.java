package LeetCode;

import java.util.*;

/*
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

示例:?

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
提示:?这与 LeetCode 目前使用的方式一致，详情请参阅?LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

说明:?不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class Solution297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

/*
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 2;
        boolean flag = root != null;
        while(!queue.isEmpty()){

            TreeNode cur = queue.remove();
            if(cur == null){
                res.append("None,");
                queue.add(null);
                queue.add(null);
            }else{
                res.append(cur.val).append(",");
                queue.add(cur.left);
                queue.add(cur.right);
                if (cur.left != null || cur.right != null) {
                    flag = true;
                }
            }
            if ((count & (count++ - 1)) == 0) {
                if (flag) {
                    flag = false;
                } else {
                    break;
                }
            }
        }
        //res.setLength(res.length() - 1);
        //res.append("]");
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("".equals(data))
            return null;
        String[] strings = data.split(",");
        TreeNode[] nodes = new TreeNode[strings.length];
        //List<String> list = new ArrayList<>(strings.length);
        int temp;

        if (!"None".equals(strings[0])) {
            temp = Integer.parseInt(strings[0]);
            nodes[0] = new TreeNode(Integer.parseInt(strings[0]));
        } else {
            return null;
        }

        for (int i = 1; i < nodes.length; i ++){
            if (!"None".equals(strings[i])) {
                temp = Integer.parseInt(strings[i]);
                if ((i & 1) != 0) {
                    nodes[i] = new TreeNode(temp);
                    nodes[(i - 1) / 2].left = nodes[i];
                } else {
                    nodes[i] = new TreeNode(temp);
                    nodes[(i - 1) / 2].right = nodes[i];
                }
            }
        }
        return nodes[0];
    }
    */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        dfs1(res,root);
        return res.toString();
    }

    public void dfs1(StringBuffer res, TreeNode root){
        if(root == null){
            res.append("#,");
            return;
        }

        res.append(root.val).append(',');
        dfs1(res,root.left);
        dfs1(res,root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> res1 = new LinkedList<String>(Arrays.asList(data.split(",")));
        return dfs2(res1);
    }

    public TreeNode dfs2(Queue<String> res1){
        String str = res1.poll();
        if(str.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs2(res1);
        node.right = dfs2(res1);
        return node;
    }

/*
    public  void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node5.right = node6;
        String a =  serialize(node1);
        deserialize(a);
    }
*/
}
