package SwordRefersOffer;
/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution25 {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        RandomListNode res = new RandomListNode(0);
        RandomListNode cur = pHead, res_next = res, next;

        while(cur != null){
            res_next.next = new RandomListNode(cur.label);
            res_next = res_next.next;
            res_next.random = cur.random;
            cur = cur.next;
        }

        cur = pHead;
        res_next = res.next;
        while(cur != null){
            next = cur.next;
            cur.next = res_next;
            res_next = res_next.next;
            cur = next;
        }

        res_next = res.next;
        while(res_next != null){
            if (res_next.random != null){
                res_next.random = res_next.random.next;
            }

            res_next = res_next.next;
        }
        return res.next;
    }

    public static void main(String[] args){
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        a.random = c;
        b.random = e;
        c.random = null;
        d.random = b;
        e.random = null;
        Clone(a);
    }
}
