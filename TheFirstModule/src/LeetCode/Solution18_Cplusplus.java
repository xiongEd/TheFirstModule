package LeetCode;
/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class Solution18_Cplusplus {
    /*
    public:
	vector<vector<int>> fourSum(vector<int>& nums, int target) {
		int n = nums.size();
		vector<vector<int>>res;
		if(n < 4)
			return res;
		sort(nums.begin(),nums.end());
		int i,j,m,k,arr0,arr1,sum;
		for(int k = 0; k < n - 3; ++k)
			{
			if(k > 0 && nums[k] == nums[k - 1])
					continue;
			if (nums[k] + nums[k+1] + nums[k+2] + nums[k+3] > target)
            {
                break;
            }
            if (nums[k] + nums[n-3] + nums[n-2] + nums[n-1] < target)
            {
                continue;
            }
			arr0 = target - nums[k];
			for(i = k + 1; i < n - 2; ++ i)
			{
				if(i > k + 1 && nums[i] == nums[i - 1])
					continue;
				if (nums[k] + nums[i] + nums[n-2] + nums[n-1] < target)
                {
                    continue;
                }
                if (nums[k] + nums[i] + nums[i+1] + nums[i+2] > target)
                {
                    break;
                }

				arr1 = arr0 - nums[i];
				j = n - 1;
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

					if(sum > arr1)
						{
						-- j;
						continue;
						}
					if(sum < arr1)
						{
						++ m;
						continue;
						}

					res.push_back(vector<int>{nums[k],nums[i],nums[m],nums[j]});
					++ m;
					-- j;
					}
				}
			}
		return res;
	}
     */
}
