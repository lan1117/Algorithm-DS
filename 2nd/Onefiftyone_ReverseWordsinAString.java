package 二刷;
import java.util.*;
public class Onefiftyone_ReverseWordsinAString {
	public String reverseWords(String s){
		String[] res = s.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i = res.length - 1; i >= 0; i--){
			sb.append(res[i] + " ");
		}
		return sb.toString().trim();
	}
	//if s.split(" "): s = " ";
	//if s.trim().split(" "): s = " a    b" -> "b     a" expected: "b a"
	//-> s.trim().split("\\s+")
}
