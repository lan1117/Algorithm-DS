package backtracking;
import java.util.*;

/*
 * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.

 */
public class FactorCombinations {
	public List<List<Integer>> getFactors(int n){
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<Integer>(), n, 2);
		return res;
	}
	public void helper(List<List<Integer>> res, List<Integer> item, int n, int start){
		if(n <= 1){
			if(item.size() > 1){
				res.add(new ArrayList<Integer>(item));
			}
			return;
		}
		for(int i = start; i <= n; i++){
			if(n % i == 0){
				item.add(i);
				helper(res, item, n/i, i);
				item.remove(item.size() - 1);
			}
		}
	}
}
