package 二刷;
//quick sort
public class TwoFifteen_KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k){
		if(nums == null || nums.length == 0 || k > nums.length || k <= 0) return -1;
		return quickSort(nums, 0, nums.length - 1, k);
	}
	public int quickSort(int[] nums, int lo, int hi, int k){
		int l = lo, r = hi, pi = nums[hi];
		while(l < r){
			if(nums[l++] > pi){
				swap(nums, --l, --r);
			}
		}
		swap(nums, l, hi);
		int rank = nums.length - l;
		if(rank == k){
			return nums[l];
		}
		else if(rank > k){
			return quickSort(nums, l + 1, hi, k);
		}
		else{
			return quickSort(nums, lo, l-1, k);
		}
	}
	public void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
