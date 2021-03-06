package 二刷;
/*
 * The key here is to use swapping to keep constant space and also make use 
 * of the length of the array, which means there can be at most n positive integers. 
 * So each time we encounter an valid integer, find its correct position and swap. 
 * Otherwise we continue.
use while to avoid change 4 to 3 and 1 at 2
[-1,4,2,1,9,10]
 */
public class Fourtyone_FirstMissingPositive {
	public int firstMissingPositive(int[] nums){
		int n = nums.length;
        for(int i=0; i<n; i++){
            while(nums[i] > 0 && nums[i] < n && nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
        }
        int i=0;
        while(i < n && nums[i] == i+1)
            i++;
        return i+1;
	}
	private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
