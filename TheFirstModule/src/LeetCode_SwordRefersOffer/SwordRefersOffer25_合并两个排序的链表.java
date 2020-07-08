package LeetCode_SwordRefersOffer;
/*
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000
 */
public class SwordRefersOffer25_合并两个排序的链表 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode first = l1, second = l2, head, cur;
        if (first.val <= second.val) {
            head = l1;
            cur = l1;
            first = l1.next;
        } else {
            head = l2;
            cur = l2;
            second = l2.next;
        }

        while (first != null || second != null) {
            if (first == null || second == null) {
                if (first == null) {
                    cur.next = second;
                    break;
                } else {
                    cur.next = first;
                    break;
                }
            }
            if (first.val <= second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
