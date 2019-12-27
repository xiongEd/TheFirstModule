package SwordRefersOffer;
/*
输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode next = head;
        int count = 0;
        while(next != null){
            count ++;
            if(count >= k){
                res = res.next;
            }
            next = next.next;
        }
        if(count < k || k == 0)
            return null;
        return res;
    }
}
