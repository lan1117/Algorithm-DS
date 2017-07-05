package 二刷;
import java.util.*;
public class TwoTwentyseven_BasicCalculatorII {
	public int calculate(String s){
		//using a stack to calculate the * and / and store the result in the stack
		//sum up all the number in the stack
		if(s.length() == 0 || s == null) return 0;
		Stack<Integer> stack = new Stack();
		char[] str = s.toCharArray();
		int len = s.length();
		int num = 0;
		char sign = '+';
		for(int i = 0; i < len; i++){
			if(Character.isDigit(str[i])){
				num = num * 10 + str[i] - '0';
			}
			if((!Character.isDigit(str[i]) && str[i] != ' ') || i == len - 1){
				if(sign == '+') stack.push(num);
				else if(sign == '-') stack.push(-num);
				else if(sign == '*') stack.push(stack.pop() * num);
				else if(sign == '/') stack.push(stack.pop() / num);
				sign = str[i];
				num = 0;
			}
		}
		int res = 0;
		for(int i : stack) res += i;
		return res;
	}
}
