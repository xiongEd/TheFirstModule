package LeetCode;
/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 */
public class Solution23_Cplusplus {
    /*
    public:
	ListNode* mergeKLists(vector<ListNode*>& lists) {
			if (lists.size() == 0) return nullptr;
			int n = lists.size();
			while (n > 1) {
				int k = (n + 1) / 2;
				for (int i = 0; i < n / 2; ++i) {
					lists[i] = mergeTwoLists(lists[i], lists[i + k]);
				}
				n = k;
			}
			return lists[0];
		}
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		ListNode *head = new ListNode(0);
		ListNode *next = head;
		while(l1 && l2)
			{
			if(l1->val < l2->val)
				{
				next->next = l1;
				next = next->next;
				l1 = l1->next;
				}
			else
				{
				next->next = l2;
				next = next->next;
				l2 = l2->next;
				}
			}
		if(l1)
			{
			next->next = l1;
			}
		if(l2)
			{
			next->next = l2;
			}
		return head->next;
	}
     */
}
