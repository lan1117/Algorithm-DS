package 二刷;

public class Seventythree_SetMatrixZeros {
	public void setZeros(int[][] matrix){
		boolean firstRow = false, firstCol = false;
		for(int i = 0; i < matrix[0].length; i++){
			for(int j = 0; j < matrix.length; j++){
				if(matrix[i][j] == 0){
					if(i == 0) firstCol = true;
					if(j == 0) firstRow = true;
					matrix[0][i] = 0;
					matrix[j][0] = 0;
				}
			}
		}
		for(int i = 1; i < matrix[0].length; i++){
			for(int j = 1; j < matrix.length; j++){
				if(matrix[0][i] == 0 || matrix[j][i] == 0){
					matrix[j][i] = 0;
				}
			}
		}
		if(firstRow){
			for(int i = 0; i < matrix[0].length; i++){
				matrix[0][i] = 0;
			}
		}
		if(firstCol){
			for(int i = 0; i < matrix.length; i++){
				matrix[i][0] = 0;
			}
		}
	}
}
