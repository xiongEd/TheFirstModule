package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个以行程长度编码压缩的整数列表 nums 。

考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。

请你返回解压后的列表。

 

示例：

输入：nums = [1,2,3,4]
输出：[2,4,4,4]
 

提示：

2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100
 */
public class Solution1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int temp;
        for (int i = 0; i < nums.length; i += 2){
            temp = nums[i + 1];
            for (int j = 0; j < nums[i]; j ++){
                res.add(temp);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i ++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
