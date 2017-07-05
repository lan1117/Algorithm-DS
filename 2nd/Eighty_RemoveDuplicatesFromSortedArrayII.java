package 二刷;

public class Eighty_RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums){
		if(nums.length < 3) return nums.length;
		int j = 0;
		for(int n : nums){
			if(j < 2 || n > nums[j-2]){
				nums[j++] = n;
			}
		}
		return j;
	}
}
