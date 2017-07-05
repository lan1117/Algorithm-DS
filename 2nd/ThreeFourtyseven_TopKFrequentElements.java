package 二刷;
import java.util.*;

public class ThreeFourtyseven_TopKFrequentElements {
	public List<Integer> topKFrequet(int[] nums, int k){
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		for(int i : nums){
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Integer>[] sort = new List[nums.length + 1];
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(sort[entry.getValue()] == null){
				sort[entry.getValue()] = new ArrayList<>();
			}
			sort[entry.getValue()].add(entry.getKey());
		}
		for(int i = sort.length - 1; i >= 0 && res.size() < k; i--){
			if(sort[i] != null){
				res.addAll(sort[i]);
			}
		}
		return res;
	}
}
