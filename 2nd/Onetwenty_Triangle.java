package 二刷;
import java.util.*;
public class Onetwenty_Triangle {
	public int minimumTotal(List<List<Integer>> triangle){
		int[][] f = new int[triangle.size()][triangle.size()];
		f[0][0] = triangle.get(0).get(0);
		for(int i = 1; i < triangle.size(); i++){
			f[i][0] = triangle.get(i).get(0) + f[i-1][0];
			f[i][i] = triangle.get(i).get(i) + f[i-1][i-1];
		}
		for(int i = 1; i < triangle.size(); i++){
			for(int j = 1; j < i; j++){
				f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]) + triangle.get(i).get(i);
			}
		}
		int min = f[triangle.size() - 1][0];
		for(int i = 1; i < triangle.get(triangle.size() - 1).size(); i++){
			min = Math.min(min, f[triangle.size() - 1][i]);
		}
		return min;
	}
}
