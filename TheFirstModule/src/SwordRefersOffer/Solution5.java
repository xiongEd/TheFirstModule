package SwordRefersOffer;
import java.util.Stack;

/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

public class Solution5 {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(stack1.empty()){
            stack1.push(node);
        }
        else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            stack2.push(node);
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        return stack1.pop();
    }
}

