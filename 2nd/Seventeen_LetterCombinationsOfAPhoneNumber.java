package 二刷;
import java.util.*;

public class Seventeen_LetterCombinationsOfAPhoneNumber {
	String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits){
		List<String> res = new ArrayList<>();
		if(digits.length() == 0) return res;
		int len = digits.length();
		dfs("", 0, digits, len, res);
		return res;
	}
	public void dfs(String str, int degree, String digits, int len, List<String> res){
		if(degree == len){
			res.add(str);
			return;
		}
		int num = digits.charAt(degree) - '0';
		for(int i = 0; i < phone[num].length(); i++){
			dfs(str + phone[num].charAt(i), degree+1, digits, len, res);
		}
	}
}
