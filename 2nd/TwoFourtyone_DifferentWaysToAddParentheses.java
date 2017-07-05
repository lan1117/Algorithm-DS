package 二刷;
import java.util.*;
public class TwoFourtyone_DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String input){
		List<Integer> res = new LinkedList<Integer>();
		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if(c == '+' || c=='-' || c == '*'){
				String left = input.substring(0, i); //begin idx(inclusive) and end idx(exclusice)
				String right = input.substring(i+1);
				List<Integer> leftList = diffWaysToCompute(left);
				List<Integer> rightList = diffWaysToCompute(right);
				for(int a : leftList){
					for(int b : rightList){
						if(c == '-') res.add(a-b);
						if(c == '+') res.add(a+b);
						if(c == '*') res.add(a * b);
					}
				}
			}
		}
		if(res.size() == 0) res.add(Integer.valueOf(input));
		return res;
	}
}
