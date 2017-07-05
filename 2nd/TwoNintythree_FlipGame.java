package 二刷;
import java.util.*;
public class TwoNintythree_FlipGame {
	public List<String> generatePossibleNextMoves(String s){
		List<String> list = new LinkedList<>();
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == '+' && s.charAt(i-1) == '+'){
				list.add(s.substring(0, i-1) + "--" + s.substring(i+1, s.length()));
			}
		}
		return list;
	}
}
