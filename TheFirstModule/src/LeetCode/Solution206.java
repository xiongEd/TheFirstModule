package LeetCode;
/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution206 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    //方法一：迭代 O(n)
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

    /*方法二：递归 O(n)
    ListNode HEAD;
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        SolveFunction(head);
        return HEAD;
    }
    public ListNode SolveFunction(ListNode cur) {
        if (cur.next == null) {
            HEAD = cur;
            return cur;
        }
        ListNode temp = SolveFunction(cur.next);
        temp.next = cur;
        cur.next = null;
        return cur;
    }
    */
}
