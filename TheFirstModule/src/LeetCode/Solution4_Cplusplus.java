package LeetCode;
/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 */
public class Solution4_Cplusplus {
    /*
    public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
		int m = nums2.size();

		if(n > m)
			{
			return findMedianSortedArrays(nums2,nums1);
			}

		int Left_Max_1, Right_Min_1, Left_Max_2, Right_Min_2, cut1, cut2, low = 0, high = 2 * n;

		while(low <= high)
		{
			cut1 = (low + high)/2;
			cut2 = m + n - cut1;

			Left_Max_1 = (cut1 == 0) ? INT_MIN : nums1[(cut1 - 1) / 2];
			Right_Min_1 = (cut1 == 2*n) ? INT_MAX : nums1[cut1 / 2];
			Left_Max_2 = (cut2 == 0) ? INT_MIN : nums2[(cut2 - 1) / 2];
			Right_Min_2 = (cut2 == 2*m) ? INT_MAX : nums2[cut2 / 2];

			if(Left_Max_1 > Right_Min_2)
				{
				high = cut1 - 1;
				}
			else if(Left_Max_2 > Right_Min_1)
				{
				low = cut1 + 1;
				}
			else
				{
				break;
				}
		}

		double Lmax,Rmin;
		Lmax = Left_Max_1 > Left_Max_2 ? Left_Max_1 : Left_Max_2;
		Rmin = Right_Min_1 < Right_Min_2 ? Right_Min_1 : Right_Min_2;
		return (Lmax + Rmin) / 2.0;
    }
     */
}
