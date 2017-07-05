package 二刷;
import java.util.*;

public class Thirty_SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words){
		List<Integer> res = new LinkedList<>();
		if(s == null || s.length() == 0 || words == null | words.length == 0){
			return res;
		}
		Map<String, Integer> map = new HashMap<>();
		int m = words[0].length();
		for(String w : words){
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
		for(int i = 0; i <= s.length() - m * words.length; i++){
			Map<String, Integer> copy = new HashMap<>(map);
			for(int j = 0; j < words.length; j++){
				String word = s.substring(i + j * m, i + (j + 1) * m);
				if(!copy.containsKey(word)) break;
				copy.put(word, copy.get(word) - 1);
				if(copy.get(word) == 0){
					copy.remove(word);
				}
				if(copy.isEmpty()){
					res.add(i);
					break;
				}
			}
		}
		return res;
	}
}
