package 二刷;
import java.util.*;

public class Eightyfour_LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights){
		int n = heights.length;
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i <= heights.length; i++){
			int h = i == n ? 0 : heights[i];
			if(stack.isEmpty() || h >= heights[stack.peek()]){
				stack.push(i);
			}
			else{
				int top = stack.pop();
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				int area = heights[top] * width;
				max = Math.max(max, area);
				i--;
			}
		}
		return max;
	}
}
