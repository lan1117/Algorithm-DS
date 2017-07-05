package 二刷;
/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity 
should be O(log (m+n)).
 */
public class Four_MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int n = nums1.length + nums2.length;
		if((n & 1) == 1){ //odd case
			return findKthSmall(nums1, nums2, 0, 0, (n + 1) >> 1);
		}
		else{
			return (findKthSmall(nums1, nums2, 0, 0, n >> 1) + (findKthSmall(nums1, nums2, 0, 0, n>>1 + 1))) / 2.0;
		}
	}
	public int findKthSmall(int[] nums1, int[] nums2, int s1, int s2, int k){
		//num1 out of bound
		if(s1 >= nums1.length){
			return nums2[s2+k-1];
		}
		if(s2 >= nums2.length){
			return nums1[s1+k-1];
		}
		if(k == 1){
			return Math.min(nums1[s1], nums2[s2]);
		}
		
		int a1 = s1 + k/2 - 1 < nums1.length ? nums1[s1+k/2-1] : Integer.MAX_VALUE;
		int a2 = s2 + k/2 - 1 < nums2.length ? nums2[s2+k/2-1] : Integer.MAX_VALUE;
		if(a1 < a2){
			return findKthSmall(nums1, nums2, s1+k/2, s2, k-k/2);
		}
		else{
			return findKthSmall(nums1, nums2, s1, s2+k/2, k-k/2);
		}
	}
}
