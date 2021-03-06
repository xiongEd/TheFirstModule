package LeetCode;

import LeetCode_SwordRefersOffer.SwordRefersOffer25_合并两个排序的链表;

/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class Solution21_Cplusplus {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

    /*
    public:
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		ListNode *head = new ListNode(0);
		ListNode *next = head;
		while(l1 && l2)
			{
			if(l1->val < l2->val)
				{
				next->next = new ListNode(l1->val);
				next = next->next;
				l1 = l1->next;
				}
			else
				{
				next->next = new ListNode(l2->val);
				next = next->next;
				l2 = l2->next;
				}
			}
		if(l1)
			{
			while(l1)
				{
				next->next = new ListNode(l1->val);
				next = next->next;
				l1 = l1->next;
				}
			}
		if(l2)
			{
			while(l2)
				{
				next->next = new ListNode(l2->val);
				next = next->next;
				l2 = l2->next;
				}
			}
		return head->next;
		}
     */
}
