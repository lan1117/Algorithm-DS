package 二刷;
import java.util.*;

public class Thirtynine_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> list = new ArrayList<>();
		backtrack(candidates, list, new ArrayList<>(), target, 0);
		return list;
	}
	public void backtrack(int[] candidates, List<List<Integer>> list, ArrayList<Integer> tempList, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else{
			for(int i = start; i < candidates.length; i++){
				tempList.add(candidates[i]);
				backtrack(candidates, list, tempList, remain - candidates[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
