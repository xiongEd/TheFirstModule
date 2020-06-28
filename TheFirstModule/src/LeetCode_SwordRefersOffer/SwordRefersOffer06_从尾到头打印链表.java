package LeetCode_SwordRefersOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 

限制：

0 <= 链表长度 <= 10000
 */
public class SwordRefersOffer06_从尾到头打印链表 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while(listNode != null){
            res.add(listNode.val);
            listNode = listNode.next;
        }
        int len = res.size();
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i --) {
            result[len - 1 - i] = res.get(i);
        }
        return result;
    }
}
