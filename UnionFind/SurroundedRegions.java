package UnionFind;

//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//A region is captured by flipping all 'O's into 'X's in that surrounded region.

public class SurroundedRegions {
	public void solve(char[][] board){
		if(board == null || board.length == 0){
			return;
		}
		//first and last col
		for(int i = 0; i < board.length; i ++){
			dfs(board, i, 0);
			dfs(board, i, board[0].length - 1);
		}
		//first and last row
		for(int i = 1; i < board[0].length - 1; i ++){
			dfs(board, 0, i);
			dfs(board, board.length - 1, i);
		}
		for(int i = 0; i < board.length; i ++){
			for(int j = 0; j < board[0].length; j ++){
				if(board[i][j] == 'K')
					board[i][j] = 'O';
				else if(board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}
	public void dfs(char[][] board, int row, int col){
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O'){
			return;
		}
		board[row][col] = 'K';
		dfs(board, row + 1, col);
		dfs(board, row - 1, col);
		dfs(board, row, col + 1);
		dfs(board, row, col - 1);
	}
}
