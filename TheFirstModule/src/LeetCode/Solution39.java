package LeetCode;
import java.util.*;
import java.lang.*;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public  class Solution39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        SolveFunction(res,temp, candidates,candidates.length - 1,target,0);
        return res;
    }

    public static void SolveFunction(List<List<Integer>> res, List<Integer> temp,int[] candidates,int cur, int target, int sum){
        for(Integer i = cur; i >= 0 ; -- i){
            if(candidates[i] > target - sum){
                continue;
            }
            else if(candidates[i] == target - sum){

                temp.add(candidates[i]);

                res.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size() - 1);
            }
            else{
                sum += candidates[i];
                temp.add(candidates[i]);
                SolveFunction(res, temp , candidates, i ,target, sum);
                sum -= candidates[i];
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        int[] a = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.addAll(combinationSum(a,target));
        for(List<Integer> b : res) {
            System.out.println(b.size());
            for (int i = 0; i < b.size(); i++) {
                System.out.print(b.get(i));
            }
            System.out.println();
        }
    }
}
