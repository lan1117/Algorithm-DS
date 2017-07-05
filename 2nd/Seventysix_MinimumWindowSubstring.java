package 二刷;

public class Seventysix_MinimumWindowSubstring {
	public String minWindow(String s, String t){
		String res = "";
		if(s == null || t == null || s.length() == 0 || t.length() == 0) return res;
		int n = s.length(), m = t.length();
		int min = Integer.MAX_VALUE;
		int[] count = new int[256];
		for(char c : t.toCharArray()){
			count[c]++;
		}
		for(int i = 0, j = 0; j < n; j++){
			if(count[s.charAt(j)]-- > 0){
				m--;
			}
			while(m == 0){
				if(j - i + 1 < min){
					res = s.substring(i,  j+1);
					min = j - i + 1;
				}
				if(count[s.charAt(i++)]++ == 0){
					m++;
				}
			}
		}
		return res;
	}
}
