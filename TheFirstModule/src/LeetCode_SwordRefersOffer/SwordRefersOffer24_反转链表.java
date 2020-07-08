package LeetCode_SwordRefersOffer;
/*
Solution206
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000
 */
public class SwordRefersOffer24_反转链表 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode last = null, cur = head, next;
        while (cur.next != null) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        cur.next = last;
        return cur;
    }
}
