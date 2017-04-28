package backtracking;
import java.util.*;
//contains duplicates
public class PermutationsII {
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, nums, new ArrayList<>(), new boolean[nums.length]);
		return list;
	}
	private void backtrack(List<List<Integer>> list, int[] nums, List<Integer> tempList, boolean[] used){
		if(tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
		else{
			for(int i = 0; i < nums.length; i ++){
				if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, nums, tempList, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
