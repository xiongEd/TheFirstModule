package LeetCode;
/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution16_Cplusplus {
    /*
    public:
		int threeSumClosest(vector<int>& nums, int target) {
			int res;
			int i = 0, j = 0,arr,m,sum = 0,flag = INT_MAX,temp;
			sort(nums.begin(),nums.end());

			if(nums.size() < 3)
				return res;
			if(3 * nums[0] >= target)
				return nums[0] + nums[1] + nums[2];

			for(i; i < nums.size() - 2; ++ i)
				{
				if(i > 0 && nums[i] == nums[i - 1])
					continue;

				arr = target - nums[i];
				j = nums.size() - 1;
				m = i + 1;
				while (m <j)
					{
					if(j < nums.size() - 1 && nums[j] == nums[j + 1])
						{
						--j;
						continue;
						}

					if(m > i+1 && nums[m] == nums[m - 1])
						{
						++m;
						continue;
						}

					sum = nums[j] + nums[m] - arr;
					temp = sum > 0 ? sum : -sum;
					if(temp< flag)
						{
						flag = temp;
						res = nums[i] + nums[m] + nums[j];
						}

					if(sum > 0)
						{
						-- j;
						continue;
						}
					if(sum < 0)
						{
						++ m;
						continue;
						}

					return target;
					}
				}

			return res;
		}
     */
}
