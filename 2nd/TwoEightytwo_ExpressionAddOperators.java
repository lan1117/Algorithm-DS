package 二刷;
import java.util.*;
public class TwoEightytwo_ExpressionAddOperators {
	public List<String> addOperators(String num, int target){
		List<String> res = new ArrayList<>();
		if(num == null || num.length() == 0) return res;
		dfs(num, target, res, new StringBuilder(), 0, 0, 0);
		return res;
	}
	//Time O(4^n)
	public void dfs(String num, int target, List<String> res, StringBuilder sb, double val, double pre, int start){
		if(start == num.length()){
			if(val == target){
				res.add(sb.toString());
			}
			return;
		}
		for(int i = start; i < num.length(); i++){
			if(i > start && num.charAt(start) == '0'){
				break;
			}
			long cur = Long.parseLong(num.substring(start, i+1)); //avoid overflow
			int len = sb.length();
			if(start == 0){
				dfs(num, target, res, sb.append(cur), cur, cur, i+1);
				sb.setLength(len);
			}else{
				dfs(num, target, res, sb.append("+" + cur), val + cur, cur, i+1);
				sb.setLength(len);
				dfs(num, target, res, sb.append("-" + cur), val - cur, -cur, i+1);
				sb.setLength(len);
				dfs(num, target, res, sb.append("*" + cur), val - pre + pre * cur, pre * cur, i+1);
				sb.setLength(len);
			}
		}
	}
}
