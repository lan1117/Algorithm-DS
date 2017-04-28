package DivideAndConquer;
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays. 
//The overall run time complexity should be O(log (m+n)).

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArray(int[] nums1, int[] nums2){
		int n = nums1.length + nums2.length;
		if((n&1) == 1){
			return findKthSmall(nums1, nums2, 0, 0, (n + 1) >> 1);
		}
		else{
			return (findKthSmall(nums1, nums2, 0, 0, n >> 1) + findKthSmall(nums1, nums2, 0, 0, (n >> 1) + 1)) / 2.0;
		}
	}
	public double findKthSmall(int[] nums1, int[] nums2, int s1, int s2, int k){
		if(s1 >= nums1.length){
			
		}
		int a1 = s1 + k / 2 - 1 < nums1.length ? nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE;
		int a2 = s2 + k / 2 - 1 < nums2.length ? nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE;
		if(a1 < a2){
			return findKthSmall(nums1, nums2, s1 + k / 2, s2, k - k / 2);
		}
		else{
			return findKthSmall(nums1, nums2, s1, s2 + k / 2, k - k / 2);
		}
	}
}
