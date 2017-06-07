package backtracking;
import java.util.*;
/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 */

public class PalindromePartitioning {
	public List<List<String>> partition(String s){
		List<List<String>> list = new ArrayList<>();
		backtrack(list, s, new ArrayList<>(), 0);
		return list;
	}
	private void backtrack(List<List<String>> list, String s, List<String> tempList, int start){
		if(start == s.length()) list.add(new ArrayList<>(tempList));
		else{
			for(int i = start; i < s.length(); i ++){
				if(isPalindrome(s, start, i)){
					tempList.add(s.substring(start,  i + 1));
					backtrack(list, s, tempList, i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}
	private boolean isPalindrome(String s, int i, int j){		
		//int i = 0, j = s.length() - 1;
		while(i < j){
			if(s.charAt(i) != s.charAt(j)) return false;
			i++; j--;
		}	
		return true;
	}
}
