package 二刷;
import java.util.*;

public class Onefifty_EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens){
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < tokens.length; i++){
			if(tokens[i].equals("+")){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			}
			else if(tokens[i].equals("-")){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			}
			else if(tokens[i].equals("*")){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a*b);
			}
			else if(tokens[i].equals("/")){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			}
			else{
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		return stack.pop();
	}
}
