package 二刷;
import java.util.*;
public class TwoEightyeight_UniqueWordAbbreviation {
	HashMap<String, ArrayList<String>> map = new HashMap<>();
	public TwoEightyeight_UniqueWordAbbreviation (String[] dictionary){
		for(String s : dictionary){
			String abbs = getabbr(s);
			if(map.containsKey(abbs)){
				map.get(abbs).add(s);
			}else{
				ArrayList<String> list = new ArrayList<>();
				list.add(s);
				map.put(abbs, list);
			}
		}
	}
	public boolean isUnique(String word){
		String s0 = getabbr(word);
		if(map.containsKey(s0)){
			for(String s : map.get(s0)){
				if(word.equals(s)) continue;
				else return false;
			}
			return true;
		}else return true;
	}
	public String getabbr(String s){
		int count = s.length() - 2;
		StringBuilder sb = new StringBuilder();
		if(count <= 0) return s;
		else{
			sb.append(s.charAt(0));
			sb.append(String.valueOf(count));
			sb.append(s.charAt(s.length() - 1));
			return sb.toString();
		}
	}
}
