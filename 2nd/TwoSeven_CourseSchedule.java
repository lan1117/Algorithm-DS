package 二刷;
import java.util.*;
public class TwoSeven_CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites){
		int[] degree = new int[numCourses];
		List<Integer>[] course  =new List[numCourses];
		for(int i = 0; i < prerequisites.length; i++){
			int cur = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if(course[pre] == null){
				course[pre] = new LinkedList<>();
			}
			course[pre].add(cur);
			degree[cur]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < degree.length; i++){
			if(degree[i] == 0){
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()){
			int cur = queue.poll();
			numCourses--;
			List<Integer> list = course[cur];
			if(list == null) continue;
			for(int i = 0; i < list.size(); i++){
				if(--degree[list.get(i)] == 0){
					queue.offer(list.get(i));
				}
			}
		}
		return numCourses == 0;
	}
}
