package 二刷;

public class Oneeightysix_ReverseWordsInAString {
	public void reverseWords(char[] s){
		reverse(s, 0, s.length-1);
		int k = 0;
		for(int i = 0; i < s.length; i++){
			if(s[i] == ' '){
				reverse(s, k, i-1);
				k = i+1;
			}
		}
		reverse(s, k, s.length - 1);
	}
	public void reverse(char[] s, int i, int j){
		while(i < j){
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
			i++;
			j--;
		}
	}
}
