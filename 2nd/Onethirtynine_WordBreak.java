package 二刷;
import java.util.*;

public class Onethirtynine_WordBreak {
	public boolean wordBreak(String s, List<String> wordDict){
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1; i < s.length(); i++){
			for(int j = 0; j < 1; j++){
				String word = s.substring(j,  i);
				dp[i] = dp[i] || dp[j] && wordDict.contains(word);
			}
		}
		return dp[s.length()];
	}
}
