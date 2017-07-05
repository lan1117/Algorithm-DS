package 二刷;
import java.util.*;
public class TwoFiftyfour_FactorCombinations {
	public List<List<Integer>> getFactors(int n){
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, n, new ArrayList<>(), 2);
		return res;
	}
	public void backtrack(List<List<Integer>> res, int n, List<Integer> tempList, int start){
		if(n == 1){
			if(tempList.size() > 1)
				res.add(new ArrayList<>(tempList));
			return;
		}
		for(int i = start; i <= n; i++){
			if(n % i == 0){
				tempList.add(i);
				backtrack(res, n / i, tempList, i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
