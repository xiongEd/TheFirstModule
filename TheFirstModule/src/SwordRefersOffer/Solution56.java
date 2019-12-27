package SwordRefersOffer;
/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class Solution56 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;

        ListNode res = new ListNode(0);
        ListNode last = pHead, next = pHead, pres = res;

        if (pHead.next.val > pHead.val){
            pres.next = pHead;
            pres = pres.next;
        }

        while (next.next != null){
            next = next.next;
            if (next.val > last.val){
                if (next.next == null){
                    pres.next = next;
                    pres = pres.next;
                    break;
                }
                else {
                    if (next.val < next.next.val){
                        pres.next = next;
                        pres = pres.next;
                    }
                    else {
                        next = next.next;
                    }
                }
            }
            last = next;
        }

        pres.next = null;
        return res.next;
    }
}
