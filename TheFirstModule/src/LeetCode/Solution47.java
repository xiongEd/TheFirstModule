package LeetCode;
import java.util.*;
/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class Solution47 {
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> temp2 = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(Integer c : nums)
            temp2.add(c);
        SolveFunction(res,temp,temp2,temp2.size());
        return res;
    }

    public static void SolveFunction(List<List<Integer>> res, List<Integer> temp, List<Integer> nums, int size){
        int mem  = 0;
        for(int i = 0;i < nums.size(); i ++){
            mem = nums.get(i);
            if(i > 0 && mem == nums.get(i - 1))
                continue;
            temp.add(mem);
            nums.remove(i);
            if(temp.size() == size){
                res.add(new ArrayList<Integer>(temp));
                nums.add(i, mem);
                temp.remove(temp.size() - 1);
                return;
            }
            SolveFunction(res, temp, nums, size);
            nums.add(i, mem);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        int[]a = {1,1,3,4};
        List<List<Integer>> b;
        b = permuteUnique(a);
        System.out.println("count:" + b.size());
        for(List<Integer> c : b) {
            for (int d : c) {
                System.out.print(d);
            }
            System.out.println();
        }
    }
}
