package 二刷;
import java.util.*;
public class Onethirtyone_PalindromePartitioning {
	public List<List<String>> palindrome(String s){
		List<List<String>> res = new ArrayList<>();
		backtrack(res, s, new ArrayList<>(), 0);
		return res;
	}
	public void backtrack(List<List<String>> res, String s, List<String> tempList, int start){
		if(start == s.length()){
			res.add(new ArrayList<>(tempList));
			return;
		}
		for(int i = start; i < s.length(); i++){
			if(isPalin(s, start, i)){
				tempList.add(s.substring(start, i+1));
				backtrack(res, s, tempList, i+1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	public boolean isPalin(String s, int i, int j){
		while(i < j){
			if(s.charAt(i++) != s.charAt(j--)) return false;
		}
		return true;
	}
}
