package 二刷;
/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 */
public class Five_LongestPalindromicSubstring {
	int lo = 0, hi = 0;
	public String LongestPalindrom(String s){
		int len = s.length();
		if(len < 2) return s;
		for(int i = 0; i < len - 1; i++){
			find(s, i, i); //find palindrome for odd length
			find(s, i, i+1); //find palindrom for even length
		}
		//substring(begin, end); begin is inclusive end is exclusive;
		return s.substring(lo,  hi);
	}
	public void find(String s, int i, int j){
		while(i >= 0 && j <s.length() && s.charAt(i) == s.charAt(j)){
			i--;
			j++;
		}
		if(j-i-1 > hi-lo){
			lo = i+1;
			hi = j;
		}
	}
}
