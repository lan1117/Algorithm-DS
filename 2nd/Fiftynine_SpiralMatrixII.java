package 二刷;

public class Fiftynine_SpiralMatrixII {
	public int[][] generateMatrix(int n){
		int[][] res = new int[n][n];
		int rowBegin = 0, colBegin = 0, rowEnd = n - 1, colEnd = n - 1;
		int begin = 1;
		while(rowBegin <= rowEnd && colBegin <= colEnd){
			for(int j = colBegin; j <= colEnd; j++){
				res[rowBegin][j] = begin++;
			}
			rowBegin++;
			
			for(int j = rowBegin; j <= rowEnd; j++){
				res[j][colEnd] = begin++;
			}
			colEnd--;
			
			if(colBegin <= colEnd){
				for(int j = colEnd; j >= colBegin; j--){
					res[rowEnd][j] = begin++;
				}
			}
			rowEnd--;
			
			if(rowBegin <= rowEnd){
				for(int j = rowEnd; j >= rowBegin; j--){
					res[j][colBegin] = begin++;
				}
			}
			colBegin++;
		}
		return res;
	}
}
