package 二刷;
/*
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai)
 *  and (i, 0). Find two lines, which together with x-axis forms a container, 
 *  such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */
public class Eleven_ConainerWithMostWater {
	public int maxArea(int[] height){
		/*int max = 0;
		for(int i = 1; i < height.length; i++){
			for(int j = 0; j < i; j++){
				int tmp = Math.min(height[i], height[j]) * (i - j);
				max = Math.max(max, tmp);
			}
		}
		return max;*/
		int i = 0, j = height.length - 1, max = 0;
		while(i < j){
			max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			if(height[i] > height[j]) j--;
			else i++;
		}
		return max;
	}
}
