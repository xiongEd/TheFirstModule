package SwordRefersOffer;
/*
 *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
 *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
 *3、拆分链表，将链表拆分为原链表和复制后的链表
 */
public class Solution25_Ex {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode p=pHead;
        RandomListNode t=pHead;

        while(p!=null){
            RandomListNode q=new RandomListNode(p.label);
            q.next=p.next;
            p.next=q;
            p=q.next;
        }

        while(t!=null){
            RandomListNode q=t.next;
            if(t.random!=null)
                q.random=t.random.next;
            t=q.next;
        }

        RandomListNode s=new RandomListNode(0);
        RandomListNode s1=s;
        while(pHead!=null){
            RandomListNode  q=pHead.next;
            pHead.next=q.next;
            q.next=s.next;
            s.next=q;
            s=s.next;
            pHead=pHead.next;
        }

        return s1.next;
    }
}
