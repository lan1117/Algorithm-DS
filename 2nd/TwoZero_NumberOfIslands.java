package 二刷;

public class TwoZero_NumberOfIslands {
	public int numIslands(char[][] grid){
		if(grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		int num = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == '1'){
					num++;
					dfs(grid, i, j);
				}
			}
		}
		return num;
	}
	public void dfs(char[][] grid, int i, int j){
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
		grid[i][j] = '0';
		if(i > 0) dfs(grid, i - 1, j);
		if(i < grid.length - 1) dfs(grid, i + 1, j);
		if(j > 0) dfs(grid, i, j-1);
		if(j < grid[0].length - 1) dfs(grid, i, j+1);
	}
}
