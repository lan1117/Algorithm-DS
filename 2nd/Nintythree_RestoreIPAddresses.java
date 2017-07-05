package 二刷;
import java.util.*;

public class Nintythree_RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s){
		List<String> res = new LinkedList<>();
		dfs(s, res, "", 0, 0);
		return res;
	}
	public void dfs(String s, List res, String str, int idx, int count){
		if(count == 4 && idx == s.length()){
			res.add(str);
			return;
		}
		if(count > 3) return;
		for(int i = 1; i < 4; i++){
			if(idx + i > s.length()) break;
			String add = s.substring(idx, idx+i);
			if((add.charAt(0) == '0' && add.length() > 1) || Integer.parseInt(add) > 255) continue;
			dfs(s, res, str+add+(count == 3 ? "": "."), idx+i, count+1);
		}
	}
}
