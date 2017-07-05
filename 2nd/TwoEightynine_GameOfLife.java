package 二刷;

public class TwoEightynine_GameOfLife {
	public void gameOfLife(int[][] board){
		//in order to replace the board in place, we assign the 1st bit for initial state
		//2nd bit for the next state, and shit all the number right by one in the end
		int n = board.length;
		int m = board[0].length;
		for(int row = 0; row < n; row++){
			for(int col = 0; col < m; col++){
				int lives = findLives(board, row, col);
				if(board[row][col] == 0 && lives == 3) board[row][col] = 2;
				if(board[row][col] == 1 && (lives == 2 || lives == 3)) board[row][col] = 3;
			}
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				board[i][j] >>= 1;
			}
		}
	}
	public int findLives(int[][] board, int row, int col){
		int n = board.length;
		int m = board[0].length;
		int lives = 0;
		for(int i = Math.max(row - 1, 0); i <= Math.min(n-1,  row+1); i++){
			for(int j = Math.max(col - 1, 0); j <= Math.min(m-1, col+1); j++){
				lives += board[i][j] & 1;
			}
		}
		lives -= board[row][col] & 1;
		return lives;
	}
}
