package 二刷;
import java.util.*;
public class TwoNinteen_ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			Integer duplicate = map.put(nums[i], i);
			if(duplicate != null && i - duplicate <= k) return true;
		}
		return false;
	}
}
