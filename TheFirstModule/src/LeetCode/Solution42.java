package LeetCode;
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */
public class Solution42 {
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        return solveFunction(height);
    }

    public int solveFunction(int[] height){
        int sum = 0,cur = 0,last = -1,temp;
        boolean flag = true;

        for(int i = 1; i < height.length; i ++){
            if(height[i] > height[i - 1]){
                flag = true;
                cur = i;
            }
            else if(height[i] == height[i - 1]){
                cur = i;
            }
            else{
                if(!flag){
                    continue;
                }
                if(last == -1){
                    last = cur;
                }
                else{
                    temp = height[last] < height[cur] ? height[last] : height[cur];
                    while(++last < cur){
                        if(height[last] < temp) {
                            sum += temp - height[last];
                            height[last] = temp;
                        }
                    }
                    flag = false;
                }
            }
        }
        if(flag){
            if(last != -1) {
                temp = height[last] < height[cur] ? height[last] : height[cur];
                while (++last < cur) {
                    if(height[last] < temp) {
                        sum += temp - height[last];
                        height[last] = temp;
                    }
                }
            }
        }
        if(sum == 0)
            return 0;

        return sum + solveFunction(height);
    }
}
