package LeetCode;
/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Solution15_Cplusplus {
    /*
    public:
	vector<vector<int>> threeSum(vector<int>& nums) {
		vector<vector<int>>res;
		int i = 0, j = 0,arr,m,sum = 0;
		sort(nums.begin(),nums.end());
		if(nums.size() < 3) return res;
		if(nums[0] <= 0 && nums[nums.size() - 1] >= 0)
			{
			for(i; i < nums.size() - 2; ++ i)
				{
				if(i > 0 && nums[i] == nums[i - 1])
					continue;
				if(nums[i] > 0)
					break;

				arr = -nums[i];
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

					sum = nums[j] + nums[m];

					if(sum > arr)
						{
						-- j;
						continue;
						}
					if(sum < arr)
						{
						++ m;
						continue;
						}

					res.push_back(vector<int>{nums[i],nums[m],nums[j]});
					++ m;
					-- j;
					}
				}
			}
		return res;
	}
     */
}
