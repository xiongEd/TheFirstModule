package SwordRefersOffer;
import java.util.*;

/*
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

public class Solution20 {
     private Stack<Integer> Cur = new Stack<Integer>();
     private Stack<Integer> Min = new Stack<Integer>();

    public void push(int node) {
        Cur.push(node);
        if(Min.isEmpty())
            Min.push(node);
        else{
            if(node <= Min.peek()){
                Min.push(node);
            }
        }
    }

    public void pop() {
        if(Min.peek().equals(Cur.pop()))
            Min.pop();
    }

    public int top() {
        return Cur.peek();
    }

    public int min() {
        return Min.peek();
    }

}
