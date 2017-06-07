package BFSGraph;
//import java.util.PriorityQueue;
import java.util.*;
/*
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.

The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 */
public class TrappingRainWaterII {
	//data structure for each cell in the board
	class Cell implements Comparable<Cell>{
		int x, y, h;
		public Cell(int x, int y, int h){
			this.x = x;
			this.y = y;
			this.h = h;
		}
		@Override
		public int compareTo(Cell that){
			return this.h - that.h;
		}
	}
	public int trapRainWater(int[][] heightMap){
		if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
		//Initialization
		int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int vol = 0;
		int n = heightMap.length;
		int m = heightMap[0].length;
		Queue<Cell> heap = new PriorityQueue<>();
		boolean[][] visit = new boolean[n][m];
		//Add boarder cells to the heap
		for(int i = 0; i < n; i++){
			heap.offer(new Cell(i, 0, heightMap[i][0]));
			heap.offer(new Cell(i, m - 1, heightMap[i][m - 1]));
			visit[i][0] = true;
			visit[i][m - 1] = true;
		}
		for(int j = 1; j < m - 1; j++){
			heap.offer(new Cell(0, j, heightMap[0][j]));
			heap.offer(new Cell(n - 1, j, heightMap[n - 1][j]));
			visit[0][j] = true;
			visit[n - 1][j] = true;
		}
		while(!heap.isEmpty()){
			Cell cur = heap.poll();
			for(int i = 0; i < 4; i++){
				int x = cur.x + dir[i][0];
				int y = cur.y + dir[i][1];
				if(x <= 0 || x >= n - 1 || y <= 0 || y >= m - 1 || visit[x][y]){
					continue;
				}
				visit[x][y] = true;
				heap.offer(new Cell(x, y, Math.max(heightMap[x][y], cur.h)));
				vol += Math.max(0,  cur.h - heightMap[x][y]);
			}
		}
		return vol;
	}
}
