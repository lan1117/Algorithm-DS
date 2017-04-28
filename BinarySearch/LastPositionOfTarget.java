package BinarySearch;

/*Given[1, 2, 2, 4, 5, 5]
 * For target = 2, return 2.
 * For target = 5, return 5.
 * For target = 6, return -1.
 * 
 */
public class LastPositionOfTarget {
	public int lastPosition(int[] nums, int target){
		//corner case
		if(nums == null || nums.length == 0){
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(nums[mid] == target){
				start = mid;
			}
			else if(nums[mid] < target){
				start = mid;
			}
			else{
				end = mid;
			}
		}
		
		if(nums[end] == target){
			return end;
		}
		if(nums[start] == target){
			return start;
		}
		return -1;
	}
}
