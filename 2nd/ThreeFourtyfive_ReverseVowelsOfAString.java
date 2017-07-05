package 二刷;

public class ThreeFourtyfive_ReverseVowelsOfAString {
	public String reverseVowels(String s){
		if(s == null || s.length() == 0) return s;
		char[] str = s.toCharArray();
		int start = 0, end = s.length() - 1;
		String vowels = "aeiouAEIOU";
		while(start < end){
			while(start < end && !vowels.contains(str[start]+""))
				start++;
			while(start < end && !vowels.contains(str[end]+""))
				end--;
			char tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			start++;
			end--;
		}
		return String.valueOf(str);
	}
}
