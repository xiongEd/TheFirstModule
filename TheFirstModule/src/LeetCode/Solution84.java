package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

 



以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

 



图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

 

示例:

输入: [2,1,5,6,2,3]
输出: 10
 */
public class Solution84 {
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0, tempIndex, tempArea, i;
        stack.push(-1);
        for (i = 0; i < heights.length; i ++) {
            tempIndex = stack.peek();
            if (tempIndex == -1) {
                stack.push(i);
            }else {
                if (heights[i] > heights[tempIndex]) {
                    stack.push(i);
                } else {
                    while ((tempIndex = stack.peek()) != -1 && heights[i] < heights[tempIndex]) {
                        stack.pop();
                        tempArea = heights[tempIndex] * (i - stack.peek() -1);
                        result = Math.max(tempArea, result);
                    }
                    stack.push(i);
                }
            }

        }
        while ((tempIndex = stack.peek())!= -1) {
            stack.pop();
            tempArea = heights[tempIndex] * (i - stack.peek() - 1);
            result = Math.max(tempArea, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(a));
        ;
    }
}
