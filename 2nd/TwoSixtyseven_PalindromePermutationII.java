package 二刷;
import java.util.*;
public class TwoSixtyseven_PalindromePermutationII {
	public List<String> generatePalindromes(String s){
		int odd = 0;
		String mid = "";
		List<String> res = new ArrayList<>();
		List<Character> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
			odd += map.get(c) % 2 != 0 ? 1 : -1;
		}
		if(odd > 1) return res;
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			char key = entry.getKey();
			int val = entry.getValue();
			if(val % 2 != 0) mid += key;
			for(int i = 0; i < val / 2; i++) list.add(key);
		}
		backtrack(list, mid, new boolean[list.size()], new StringBuilder(), res);
		return res;
	}
	public void backtrack(List<Character>list, String mid, boolean[]used, StringBuilder sb, List<String> res){
		if(sb.length() == list.size()){
			res.add(sb.toString() + mid + sb.reverse().toString());
			sb.reverse();
			return;
		}
		for(int i = 0; i < list.size(); i++){
			if(i > 0 && list.get(i) == list.get(i - 1) && !used[i-1]) continue;
			if(!used[i]){
				used[i] = true;
				sb.append(list.get(i));
				backtrack(list, mid, used, sb, res);
				used[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
