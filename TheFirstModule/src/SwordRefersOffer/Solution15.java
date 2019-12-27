package SwordRefersOffer;
/*
输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution15 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode last = null;
        ListNode next;

        if(cur == null)
            return null;
        if(cur.next == null)
            return cur;

        while(cur.next != null){
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        cur.next = last;
        return cur;
    }
}
