package 二刷;
import java.util.*;
public class TwoTwentyfour_BasicCalculator {
	public int calculate(String s){
		int res = 0;
		int num = 0;
		int sign = 1;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			if(Character.isDigit(s.charAt(i))){
				num = 0;
				while(i < s.length() && Character.isDigit(s.charAt(i))){
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				res += num * sign;
			}
			if(i == s.length())
				return res;
			if(s.charAt(i) == '+'){
				sign = 1;
			}
			if(s.charAt(i) == '-'){
				sign = -1;
			}
			if(s.charAt(i) == '('){
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			}
			if(s.charAt(i) == ')'){
				res = res * stack.pop() + stack.pop();
			}
		}
		return res;
	}
}
