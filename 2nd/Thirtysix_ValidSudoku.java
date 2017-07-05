package 二刷;

public class Thirtysix_ValidSudoku {
	public boolean isValidSudoku(char[][] board){
		boolean[][] r = new boolean[9][9];
		boolean[][] l = new boolean[9][9];
		boolean[][] c = new boolean[9][9];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				int k = board[i][j] - '1';
				if(board[i][j] == '.') continue;
				if(r[i][k] || l[j][k] || c[i - i % 3 + j / 3][k]){
					return false;
				}
				r[i][k] = l[j][k] = c[i - i % 3 + j / 3][k] = true;
			}
		}
		return true;
	}
}
