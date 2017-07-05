package 二刷;

public class TwoEightysix_WallsAndGates {
	public void wallsAndGates(int[][] rooms){
		if(rooms == null || rooms.length == 0) return;
		int m = rooms.length;
		int n = rooms[0].length;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(rooms[i][j] == 0){
					dfs(rooms, i, j, 0);
				}
			}
		}
	}
	public void dfs(int[][] rooms, int i, int j, int level){
		if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < level) return;
		rooms[i][j] = level;
		if(i > 0) dfs(rooms, i - 1, j, level + 1);
		if(i < rooms.length - 1) dfs(rooms, i+1, j, level + 1);
		if(j > 0) dfs(rooms, i, j - 1, level + 1);
		if(j < rooms[0].length - 1) dfs(rooms, i, j + 1, level + 1);
	}
}
