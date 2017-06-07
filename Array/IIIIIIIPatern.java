package Array;
import java.util.*;
/*
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.
 */

public class IIIIIIIPatern {
	class pair{
		int min;
		int max;
		public pair(int min, int max){
			this.min = min;
			this.max = max;
		}
	}
	public boolean find132pattern(int[] nums){
		if(nums == null || nums.length < 3) return false;
		Stack<pair> stack = new Stack();
		for(int n : nums){
			if(stack.isEmpty() || n < stack.peek().min) stack.push(new pair(n, n));
			else if(n > stack.peek().min){
				pair last = stack.pop();
				if(n < last.max) return true;
				else{
					last.max = n;
					while(!stack.isEmpty() && n >= stack.peek().max) stack.pop();
					if(!stack.isEmpty() && stack.peek().min < n) return true;
					stack.push(last);
				}
			}
		}
		return false;
	}
}
