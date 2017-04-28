package backtracking;
import java.util.*;
/*
 * 
 * Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word){
		List<String> res = new ArrayList<>();
		if(word == null || word.length() == 0) return res;
		backtrack(word, res, 0, "", 0);
		return res;
	}
	private void backtrack(String word, List<String> res, int pos, String cur, int count){
		if(pos == word.length()){
			if(count > 0) cur += count;
			res.add(cur);
		}
		else{
			backtrack(word, res, pos + 1, cur, count + 1);
			backtrack(word, res, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
		}
	}
}
