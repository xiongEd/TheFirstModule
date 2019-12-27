package SwordRefersOffer;
/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Solution55 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode fast = pHead, slow = pHead;
        int count = 0;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            count ++;
            if (fast == slow) break;
        }
        if (!(fast.next != null && fast.next.next != null))
            return null;
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
