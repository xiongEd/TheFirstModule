package LeetCode;
import java.util.*;
/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        SolveFunction(res,temp, candidates,candidates.length - 1,target,0);
        return res;
    }

    public void SolveFunction(List<List<Integer>> res, List<Integer> temp,int[] candidates,int cur, int target, int sum){
        for(Integer i = cur ; i >= 0 ; -- i){
            if(candidates[i] > target - sum){
                continue;
            }
            else if(candidates[i] == target - sum){
                temp.add(candidates[i]);
                if(!res.isEmpty() && res.contains(temp)) {
                    temp.remove(temp.size() - 1);
                    continue;
                }
                res.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size() - 1);
            }
            else{
                sum += candidates[i];
                temp.add(candidates[i]);
                SolveFunction(res, temp , candidates, i - 1 ,target, sum);
                sum -= candidates[i];
                temp.remove(temp.size() - 1);
            }
        }
    }
}
