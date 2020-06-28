package LeetCode_SwordRefersOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class SwordRefersOffer09_用两个栈实现队列 {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;
    public void CQueue() { //此为构造函数，应没有返回类型，提交时删除void
        stackIn = new ArrayDeque<>();
        stackOut = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (!stackOut.isEmpty()) {
            return stackOut.poll();
        }

        if (stackIn.isEmpty()) {
            return -1;
        }

        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.poll());
        }

        return stackOut.poll();
    }
}
