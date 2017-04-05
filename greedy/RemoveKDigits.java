package greedy;
import java.util.*;
/*
 * 
 * Given a non-negative integer num represented as a string, 
 * remove k digits from the number so that the new number is the smallest possible.
Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
 */
public class RemoveKDigits {
	public String removeKdigits(String num, int k){
		if(num == null || num.length() == 0) return num;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < num.length(); i ++){
			while(!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)){
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
		}
		while(k-- > 0) stack.pop();
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) sb.append(stack.pop());
		String res = sb.reverse().toString();
		int i = 0;
		while(i < res.length() && res.charAt(i) == '0') i++;
		return i == res.length() ? "0" : res.substring(i);
	}
}
