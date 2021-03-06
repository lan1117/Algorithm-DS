package 二刷;

public class Onefiftythree_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums){
		if(nums == null || nums.length == 0) return -1;
		int start = 0, end = nums.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(nums[mid] > nums[nums.length - 1]){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(nums[start] <= nums[nums.length - 1]){
			return nums[start];
		}else{
			return nums[end];
		}
	}
}
