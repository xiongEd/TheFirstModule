package LeetCode;
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class Solution2_Cplusplus {
    /*
    public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *hHead = new ListNode(0),*p = hHead;
		int flag = 0;
		int sum = 0;
		do{
			if(l1 != NULL && l2 != NULL){
				sum = l1->val + l2->val + flag;
				flag = sum/10;
				sum %= 10;
				p->val = sum;
				l1 = l1->next;
				l2 = l2->next;
			}
			else if(l1 != NULL && l2 ==NULL){
				sum = l1->val +flag;
				flag = sum/10;
				sum %= 10;
				p->val = sum;
				l1 = l1->next;
			}
			else if(l1 == NULL && l2 != NULL){
				sum = l2->val +flag;
				flag = sum/10;
				sum %= 10;
				p->val = sum;
				l2 = l2->next;

			}
			else{
				p->val = flag;
				flag = 0;
			}

			if(l1 || l2 || flag){
				p->next = new ListNode(0);
				p = p->next;
			}
		}while(l1 || l2 || flag);

		return hHead;
    }
     */
}
