package 二刷;
import java.util.*;
public class TwoSixtyNine_AlienDictionary {
	public String alienOrder(String[] words){
		String result = "";
		if(words == null || words.length == 0) return result;
		HashMap<Character, Set<Character>> map = new HashMap<>();
		HashMap<Character, Integer> degree = new HashMap<>();
		for(String s : words){
			for(char c : s.toCharArray()){
				degree.put(c, 0);
			}
		}
		for(int i = 0; i < words.length - 1; i++){
			String a = words[i];
			String b = words[i+1];
			int len = Math.min(a.length(), b.length());
			for(int j = 0; j < len; j++){
				if(a.charAt(j) != b.charAt(j)){
					Set<Character> set = new HashSet<>();
					if(map.containsKey(a.charAt(j))) set = map.get(a.charAt(j));
					if(!set.contains(b.charAt(j))){
						set.add(b.charAt(j));
						map.put(a.charAt(j), set);
						degree.put(b.charAt(j), degree.get(b.charAt(j)) + 1);
					}
					break;
				}
			}
		}
		Queue<Character> queue = new LinkedList<>();
		for(char c : degree.keySet()){
			if(degree.get(c) == 0){
				queue.offer(c);
			}
		}
		while(!queue.isEmpty()){
			char c = queue.poll();
			result += c;
			if(map.containsKey(c)){
				for(char c2 : map.get(c)){
					degree.put(c2, degree.get(c2) - 1);
					if(degree.get(c2) == 0) queue.offer(c2);
				}
			}
		}
		if(result.length() != degree.size()) return "";
		return result;
	}
}
