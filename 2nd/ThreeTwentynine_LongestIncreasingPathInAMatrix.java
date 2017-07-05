package 二刷;

public class ThreeTwentynine_LongestIncreasingPathInAMatrix {
	public int longestIncreasingPath(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int[][] cache = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				int len = dfs(matrix, cache, i, j);
				max = Math.max(max, len);
			}
		}
		return max;
	}
	public final int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int dfs(int[][] matrix, int[][] cache, int i, int j){
		if(cache[i][j] != 0) return cache[i][j];
		int m = cache.length;
		int n = cache[0].length;
		int max = 1;
		for(int[] di : dir){
			int x = i + di[0];
			int y = j + di[1];
			if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
			int len = 1 + dfs(matrix, cache, x, y);
			max = Math.max(max, len);
		}
		cache[i][j] = max;
		return max;
	}
}
