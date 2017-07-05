package 二刷;
import java.util.*;

public class Fourtynine_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> res = new ArrayList<>();
		if(strs == null || strs.length == 0) return res;
		Map<String, List<String>> map = new HashMap<>();
		for(String s : strs){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(s);
		}
		res.addAll(map.values());
		return res;
	}
	
}
