package 二刷;
import java.util.*;
public class ThreeTwenty_GeneralizedAbbreviation {
	
	public List<String> generateAbbreviations(String word){
		List<String> res = new ArrayList<>();
		backtrack(res, new StringBuilder(), word.toCharArray(), 0, 0);
		return res;
	}
	public void backtrack(List<String> res, StringBuilder sb, char[] c, int i, int num){
		int len = sb.length();
		if(i == c.length){
			if(num != 0){
				sb.append(num);
			}
			res.add(sb.toString());
		}else{
			//abbr c[i]
			backtrack(res, sb, c, i+1, num+1);
			if(num != 0){
				sb.append(num);
			}
			//not abbr c[i]
			backtrack(res, sb.append(c[i]), c, i+1, 0);
		}
		sb.setLength(len);
	}
}
