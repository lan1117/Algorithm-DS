package 二刷;

public class LongestValidParentheses {
	public int longestValidParentheses(String s){
		//dp: O(n), O(n)
		/*if(s == null || s.length() == 0) return 0;
		int[] dp = new int[s.length()];
		int max = 0;
		
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == ')'){
				if(s.charAt(i-1) == '('){
					dp[i] = i >= 2 ? dp[i-2] + 2 : 2;
				}
				else if(i-dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '('){
					dp[i] = dp[i - 1] + 2;
					if(i - dp[i-1] >= 2){
						dp[i] += dp[i - dp[i - 1] - 2];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;*/
		//traverse: O(2n) = O(n), O(1) constant space
		int left = 0, right = 0, maxLength = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				left++;
			}
			else{
				right++;
			}
			if(left == right){
				maxLength = Math.max(maxLength, 2*right);
			}
			else if(right >= left){
				left = right = 0;
			}
		}
		left = right = 0;
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) == '('){
				left++;
			}
			else{
				right++;
			}
			if(left == right){
				maxLength = Math.max(maxLength, 2*right);
			}
			else if(left >= right){
				left=right=0;
			}
		}
		return maxLength;
	}
}
