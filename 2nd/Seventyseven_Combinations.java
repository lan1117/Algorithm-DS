package 二刷;
import java.util.*;

public class Seventyseven_Combinations {
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> res = new ArrayList<>();
		backtrack(n, res, new ArrayList<>(), k, 1);
		return res;
	}
	public void backtrack(int n, List<List<Integer>> res, List<Integer> tempList, int k, int start){
		if(tempList.size() == k){
			res.add(new ArrayList<>(tempList));
		}
		else{
			for(int i = start; i <= n; i++){
				tempList.add(i);
				backtrack(n, res, tempList, k, i+1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
