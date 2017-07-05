package 二刷;
import java.util.*;
public class ThreeOne_RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s){
		int rmL = 0, rmR = 0;
		Set<String> res = new HashSet<>();
		for(char c : s.toCharArray()){
			if(c == '('){
				rmL++;
			}else if(c == ')'){
				if(rmL == 0)
					rmR++;
				else{
					rmL--;
				}
			}
		}
		dfs(res, s, 0, new StringBuilder(), rmL, rmR, 0);
		return new ArrayList<String>(res);
	}
	public void dfs(Set<String> res, String s, int idx, StringBuilder sb, int rmL, int rmR, int count){
		if(idx == s.length() && rmL == 0 && rmR == 0 && count == 0){
			res.add(sb.toString());
			return;
		}
		if(idx == s.length() || rmL < 0 || rmR < 0 || count< 0){
			return;
		}
		int len = sb.length();
		char c = s.charAt(idx);
		if(c == '('){
			dfs(res, s, idx+1, sb, rmL-1, rmR, count);
			dfs(res, s, idx+1, sb.append(c), rmL, rmR, count+1);
		}
		else if(c == ')'){
			dfs(res, s, idx+1, sb, rmL, rmR-1, count);
			dfs(res, s, idx+1, sb.append(c), rmL, rmR, count-1);
		}
		else{
			dfs(res, s, idx+1, sb.append(c), rmL, rmR, count);
		}
		sb.setLength(len);//backtrack restore
	}
}
