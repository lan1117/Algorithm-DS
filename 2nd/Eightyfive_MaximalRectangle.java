package 二刷;
import java.util.*;

public class Eightyfive_MaximalRectangle {
	public int maximalRectangle(char[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		int n = matrix.length, m = matrix[0].length;
		int[] left = new int[m];
		int[] right = new int[m];
		int[] height = new int[m];
		Arrays.fill(right, m);
		int max = 0;
		for(int i = 0; i < n; i++){	//preceed through row by row
			int l = 0, r = m;	//left and right of current row
			for(int j = m - 1; j >= 0; j--){
				if(matrix[i][j] == '1'){
					right[j] = Math.min(r, right[j]);
				}
				else{
					right[j] = m;
					r = j;	//point to 0
				}
			}
			for(int j = 0; j < m; j++){
				if(matrix[i][j] == '1'){
					height[j]++;
					left[j] = Math.max(left[j], l);
				}
				else{
					height[j] = 0;
					left[j] = 0;
					l = j + 1;	//point to 1
				}
				max = Math.max(max, (right[j] - left[j]) * height[j]);
			}
		}
		return max;
	}
}
