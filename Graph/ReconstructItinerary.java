package graph;
import java.util.*;
import java.util.PriorityQueue;
/*
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
 * reconstruct the itinerary in order. 
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order 
when read as a single string. 
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
//因为这个是按顺序一个接一个的来，所以要用dfs。dfs是base case，while loop，最后一层先执行最后一句，所以要用.addfirst()。
public class ReconstructItinerary {
	List<String> res;
	HashMap<String, PriorityQueue<String>> flights;
	public List<String> findItinerary(String[][] tickets){
		res = new LinkedList<>();
		flights = new HashMap<>();
		for(String[] ticket : tickets){
			flights.putIfAbsent(ticket[0], new PriorityQueue<>());
			flights.get(ticket[0]).add(ticket[1]);
		}
		dfs("JFK");
		return res;
	}
	private void dfs(String departure){
		PriorityQueue<String> arrivals = flights.get(departure);
		while(arrivals != null && arrivals.size() != 0){
			dfs(arrivals.poll());
		}
		res.add(0, departure);
	}
}
