package DivideAndConquer;
import java.util.*;
/*Given a string of numbers and operators,
 *  return all possible results from computing all the different possible ways to group numbers and operators. 
 *  The valid operators are +, - and *.
*/
public class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String input){
		List<Integer> res = new LinkedList<Integer>();
		for(int i = 0; i < input.length(); i ++){
			char c = input.charAt(i);
			if(c == '+' || c == '-' || c == '*'){
				//divide
				String left = input.substring(0, i);
				String right = input.substring(i + 1);
				//divide
				List<Integer> leftList = diffWaysToCompute(left);
				List<Integer> rightList = diffWaysToCompute(right);
				
				//conquer
				//recursion function
				for(int a : leftList){
					for(int b : rightList){
						if(c == '+') res.add(a + b);
						if(c == '-') res.add(a - b);
						if(c == '*') res.add(a * b);
					}
				}
			}
		}
		if(res.size() == 0) res.add(Integer.valueOf(input));
		return res;
	}
}
