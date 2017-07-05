package 二刷;
import java.util.*;

public class ThreeFiftytwo_DataStreamAsDisjointIntervals {
	class Interval{
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e){start =s; end = e;}
	}
	TreeMap<Integer, Interval> map;
	public ThreeFiftytwo_DataStreamAsDisjointIntervals() {
		map = new TreeMap<>();
	}
	public void addNum(int val){
		if(map.containsKey(val)) return;
		Integer low = map.lowerKey(val);
		Integer high = map.higherKey(val);
		
		//case 1: merge two together
		if(low != null && high != null && map.get(low).end + 1 == val && map.get(high).start - 1 == val){
			map.get(low).end = map.get(high).end;
			map.remove(high);
		}
		else if(low != null && map.get(low).end + 1 >= val){
			map.get(low).end = Math.max(map.get(low).end, val);
		}
		else if(high != null && map.get(high).start - 1 == val){
			map.put(val, new Interval(val, map.get(high).end));
			map.remove(high);
		}else{
			map.put(val, new Interval(val, val));
		}
	}
	public List<Interval> getIntervals(){
		return new ArrayList<>(map.values());
	}
}
