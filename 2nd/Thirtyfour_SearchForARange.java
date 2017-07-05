package 二刷;

public class Thirtyfour_SearchForARange {
	public int[] searchRange(int[] nums, int target){
		int[] res = new int[2];
		if(nums == null || nums.length == 0) return new int[]{-1, -1};
		int start = 0, end = nums.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(nums[mid] < target){
				start = mid + 1;
			}
			else if(nums[mid] > target){
				end = mid - 1;
			}
			else{
				end = mid;
			}
		}
		if(nums[start] == target){
			res[0] = start;
			while(start + 1 < nums.length){
			    if(nums[start + 1] == target){
			        start++;
			    }
			    else break;
			}
			res[1] = start;
			return res;
		}
		else if(nums[end] == target){
			res[0] = end;
			while(end + 1 < nums.length){
			    if(nums[end + 1] == target){
			        end++;
			    }
			    else{
			        break;
			    }
			}
			res[1] = end;
			return res;
		}
		return new int[]{-1, -1};
	}
}
