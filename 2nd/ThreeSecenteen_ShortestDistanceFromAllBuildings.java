package 二刷;
import java.util.*;

public class ThreeSecenteen_ShortestDistanceFromAllBuildings {
	public int shortestDistance(int[][] grid){
		final int[] shift = {0, -1, 0, 1, 0};
		if(grid == null || grid[0].length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] distance = new int[m][n]; 	//record the shortest distance sum of each 0;
		int[][] reach = new int[m][n];		//record how many buildings can be reached;
		int buildingNum = 0;
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == 1){
					buildingNum++;
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[]{i, j});
					
					boolean[][] isVisited = new boolean[m][n];
					int level = 1;
					
					while(!queue.isEmpty()){
						int qSize = queue.size();
						for(int q = 0; q < qSize; q++){
							int[] curr = queue.poll();
							
							for(int k = 0; k < 4; k++){
								int nextRow = curr[0] + shift[k];
								int nextCol = curr[1] + shift[k+1];
								
								if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !isVisited[nextRow][nextCol] && grid[nextRow][nextCol] == 0){
									distance[nextRow][nextCol] += level;
									reach[nextRow][nextCol]++;
									
									isVisited[nextRow][nextCol] = true;
									queue.offer(new int[]{nextRow, nextCol});
								}
							}
						}
						level++;
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == 0 && reach[i][j] == buildingNum){
					min = Math.min(min, distance[i][j]);
				}
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
