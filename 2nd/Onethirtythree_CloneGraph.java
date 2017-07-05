package 二刷;
import java.util.*;
public class Onethirtythree_CloneGraph {
	class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x){
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node == null) return null;
		if(map.containsKey(node.label)){
			return map.get(node.label);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(clone.label, clone);
		for(UndirectedGraphNode un : node.neighbors){
			clone.neighbors.add(cloneGraph(un));
		}
		return clone;
	}
}
