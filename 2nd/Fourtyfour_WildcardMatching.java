package 二刷;

public class Fourtyfour_WildcardMatching {
	public boolean isMatch(String s, String p){
		int n = s.length(), m = p.length();
		int ps = 0, pp = 0, match = 0, idx = -1;
		while(ps < n){
			//both advance
			if(pp < m && (s.charAt(ps) == p.charAt(pp) || p.charAt(pp) == '?')){
				ps++;
				pp++;
			}
			//advance pattern store the index of s and p to restore latter
			else if(pp < m && p.charAt(pp) == '*'){
				idx = pp++;
				match = ps;
			}
			//restore the previous match from * advance string pointer
			else if(idx != -1){
				pp = idx + 1;
				ps = ++ match;
			}
			else{
				return false;
			}
		}
		while(pp < m && p.charAt(pp) == '*')
			pp++;
		return pp == m;
	}
}
