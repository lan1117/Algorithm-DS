package DivideAndConquer;
//Quick Sort
/*Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
*/

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k){
		if(nums == null || nums.length == 0 || k > nums.length || k <= 0){
			return -1;
		}
		return quickSort(nums, 0, nums.length - 1, k);
	}
	public int quickSort(int[] nums, int lo, int hi, int k){
		int l = lo, r = hi, pi = nums[hi];
		//patition to <pi and >pi
		while(l < r){
			if(nums[l ++] > pi){
				swap(nums, --l, --r);
			}
		}
		swap(nums, l, hi); //swap pi to the middle
		int rank = nums.length - l; //location of pi
		if(rank == k){
			return nums[l];
		}
		else if(rank > k){
			return quickSort(nums, l + 1, hi, k);
		}
		return quickSort(nums, lo, l - 1, k);
		
	}
	public void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
