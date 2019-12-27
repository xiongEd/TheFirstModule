package SwordRefersOffer;
/*
输入两个链表，找出它们的第一个公共结点。
 */
public class Solution36 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        int len1 = 0, len2 = 0, len;

        while (p1 != null){
            len1 += 1;
            p1 = p1.next;
        }
        while (p2 != null){
            len2 += 1;
            p2 = p2.next;
        }

        if (len1 > len2){
            p1 = pHead1;
            p2 = pHead2;
            len = len1 - len2;
        }
        else {
            p1 = pHead2;
            p2 = pHead1;
            len = len2 - len1;
        }

        while (len -- > 0){
            p1 = p1.next;
        }

        while (p1 != null && p2 != null){
            if(p1.val == p2.val && p1.next == p2.next)
                break;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
