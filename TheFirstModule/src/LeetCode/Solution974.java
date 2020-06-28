package LeetCode;

import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

 

示例：

输入：A = [4,5,0,-2,-3,1], K = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 K = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 

提示：

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000
 */
public class Solution974 {
    public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> preMap = new HashMap<>();
        int result = 0, pre = 0, temp;
        preMap.put(0, 1);
        for (int i : A) {
            pre += i;
            temp = pre % K;
            if (temp < 0) {
                temp += K;
            }
            if (preMap.containsKey(temp)) {
                result += preMap.get(temp);
                preMap.put(temp, preMap.get(temp) + 1);
            } else {
                preMap.put(temp, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-1, 2, 9};
        int K = -2;
        subarraysDivByK(a, K);
    }
}

