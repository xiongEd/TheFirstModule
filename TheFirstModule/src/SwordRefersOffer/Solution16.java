package SwordRefersOffer;

/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode res = new ListNode(0);
        res.next = null;
        ListNode next = res;
        ListNode head1 = list1, head2 = list2;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                next.next = head1;
                head1 = head1.next;
                next = next.next;
            }
            else{
                next.next = head2;
                head2 = head2.next;
                next = next.next;
            }
        }

        if(head1 == null){
            next.next = head2;
        }
        else {
            next.next = head1;
        }

        return res.next;
    }
}
