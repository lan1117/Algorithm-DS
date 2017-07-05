package 二刷;
import java.util.*;

public class ThreeThirtytwo_ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets){
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		LinkedList<String> res = new LinkedList<>();
		for(String[] str : tickets){
			map.putIfAbsent(str[0], new PriorityQueue<>());
			map.get(str[0]).add(str[1]);
		}
		dfs(map, res, "JFK");
		return res;
	}
	public void dfs(Map<String, PriorityQueue<String>> map, LinkedList<String> res, String depart){
		PriorityQueue<String> hp = map.get(depart);
		while(hp != null && !hp.isEmpty()){
			dfs(map, res, hp.poll());
		}
		res.addFirst(depart);
	}
}
