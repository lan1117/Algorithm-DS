package 二刷;

public class ThreeFour_RangeSumQuery2DImmutable {
	int[][] sum;
	public ThreeFour_RangeSumQuery2DImmutable(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int n = matrix.length;
		int m = matrix[0].length;
		sum = new int[n+1][m+1];
		for(int i = 1; i <=n; i++){
			for(int j = 1; j <= m; j++){
				sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
			}
		}
	}
	public int sumRegion(int row1, int col1, int row2, int col2){
		return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
	}
}