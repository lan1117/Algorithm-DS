package 二刷;
import java.util.*;

public class Onefiftyfive_MinStack {
	Stack<Integer> stack = new Stack<>();
	int min = Integer.MAX_VALUE;
	public Onefiftyfive_MinStack(){
		
	}
	public void push(int x){
		if(x <= min){
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}
	public void pop(){
		if(stack.peek() == min){
			stack.pop();
			min = stack.pop();
		}
		else stack.pop();
	}
	public int top(){
		return stack.peek();
	}
	public int getMin(){
		return min;
	}
}
