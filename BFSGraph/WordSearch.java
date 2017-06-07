package BFSGraph;
import java.util.*;

public class WordSearch {
	public boolean exist(char[][] board, String word){
		if(board == null || board.length == 0 || board[0].length == 0) return false;
		int n = board.length, m = board[0].length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(dfs(board, word, i, j, 0)) return true;
			}
		}
		return false;
	}
	int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public boolean dfs(char[][] board, String word, int r, int c, int k){
		if(k == word.length()) return true;
		int n = board.length, m = board[0].length;
		if(r < 0 || r >= n || c < 0 || c >= m || word.charAt(k) != board[r][c]){
			return false;
		}
		board[r][c] = '*';
		for(int[]d:dir){
			if(dfs(board, word, r + d[0], c + d[1], k + 1)){
				return true;
			}
		}
		board[r][c] = word.charAt(k);
		return false;
	}
}
