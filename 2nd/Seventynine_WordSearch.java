package 二刷;

public class Seventynine_WordSearch {
	public boolean exist(char[][] board, String word){
		if(board == null || board.length == 0 || board[0].length == 0) return false;
		int m = board.length;
		int n = board[0].length;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(dfs(i, j, board, word, 0)) return true;
			}
		}
		return false;
	}
	int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public boolean dfs(int i, int j, char[][] board, String word, int k){
		if(k == word.length()) return true;
		int m = board.length;
		int n = board[0].length;
		if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(k)) return false;
		board[i][j] = '*';
		for(int[] d : dir){
			if(dfs(i+d[0], j + d[1], board, word, k+1)) return true;
		}
		board[i][j] = word.charAt(k);
		return false;
	}
}
