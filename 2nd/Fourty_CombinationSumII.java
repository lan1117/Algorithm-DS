package 二刷;
import java.util.*;
public class Fourty_CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(candidates, list, new ArrayList<>(), target, 0);
		return list;
	}
	public void backtrack(int[] candidates, List<List<Integer>> list, ArrayList<Integer> tempList, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else{
			for(int i = start; i < candidates.length; i++){
				if(i > start && candidates[i] == candidates[i - 1]) continue;
				tempList.add(candidates[i]);
				backtrack(candidates, list, tempList, remain - candidates[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
