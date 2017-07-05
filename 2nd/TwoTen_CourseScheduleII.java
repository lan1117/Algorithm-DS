package 二刷;
import java.util.*;

public class TwoTen_CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites){
		List<Integer> res = new ArrayList<>();
		int[] degree = new int[numCourses];
		List<Integer>[] course = new List[numCourses];
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
			if(degree[i] == 0) queue.offer(i);
		}
		while(!queue.isEmpty()){
			int pre = queue.poll();
			res.add(pre);
			List<Integer> list = course[pre];
			for(int i : list){
				if(--degree[i] == 0){
					queue.offer(i);
				}
			}
		}
		
		if(res.size() == numCourses){
			int[] order = new int[numCourses];
			for(int i = 0; i < res.size(); i++){
				order[i] = res.get(i);
			}
			return order;
		}
		else{
			return new int[0];
		}
	}
}
