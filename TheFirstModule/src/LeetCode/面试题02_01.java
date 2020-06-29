package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
进阶：

如果不得使用临时缓冲区，该怎么解决？
 */
public class 面试题02_01 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode pro = head, cur;
        set.add(head.val);
        while (pro.next != null) {
            cur = pro.next;
            if (set.add(cur.val)) {
                pro = cur;
            } else {
                pro.next = cur.next;
            }
        }
        return head;
    }
}
