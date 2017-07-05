package 二刷;

public class ThreeTwentyfour_WiggleSortII {
	public void wiggleSort(int[] nums){
		if(nums == null || nums.length == 0) return;
		int n = nums.length;
		//find the median
		int mid = quickSelect(nums, 0, n-1, (n-1)/2);
		//3 way partition
		int[] tmp = new int[n];
		int lo = 0, hi = n - 1;
		for(int i = 0; i < n; i++){
			if(nums[i] < mid){
				tmp[lo++] = nums[i];
			}
			if(nums[i] > mid){
				tmp[hi--] = nums[i];
			}
		}
		for(int i = lo; i <= hi; i++){
			tmp[i] = mid;
		}
		//pick element
		lo = (n-1) / 2;
		hi = n-1;
		for(int i = 0; i < n; i++){
			if((i&1) == 0){
				nums[i] = tmp[lo--];
			}else{
				nums[i] = tmp[hi--];
			}
		}
	}
	public int quickSelect(int[] nums, int lo, int hi, int k){
		int l = lo, r = hi, pivot = nums[hi];
		while(l < r){
			if(nums[l++] > pivot){
				swap(nums, --l, --r);
			}
		}
		swap(nums, l, hi);
		if(l == k){
			return nums[l];
		}else if(l > k){
			return quickSelect(nums, lo, l-1, k);
		}
		return quickSelect(nums, l+1, hi, k);
	}
	public void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
