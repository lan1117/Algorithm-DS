package 二刷;
import java.util.*;
public class TwoSeventyone_EncodeandDecodeStrings {
	public String encode(List<String> strs){
		StringBuilder sb = new StringBuilder();
		//sb.append('#');
		for(int i = 0; i < strs.size(); i++){
			int num = strs.get(i).length();
			sb.append(num + "#");
			sb.append(strs.get(i));
		}
		return sb.toString();
	}
	public List<String> decode(String s){
		List<String> res = new ArrayList<>();
		int start = 0;
		while(start < s.length()){
			int idx = s.indexOf('$', start);
			int size = Integer.parseInt(s.substring(start, idx));
			res.add(s.substring(idx + 1, idx + size + 1));
			start = idx + size + 1;
		}
		return res;
	}
}	
