package 二刷;
import java.util.*;
public class Fiftysix_MergeIntervals {
	class Interval{
		int start;
		int end;
		Interval(){start = 0; end = 0;}
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	public List<Interval> merge(List<Interval> intervals){
		List<Interval> res = new ArrayList<>();
		if(intervals == null || intervals.size() == 0) return res;
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval in1, Interval in2){
				return in1.start - in2.start;
			}
		});
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for(int i = 1; i < intervals.size(); i++){
			if(end >= intervals.get(i).start){
				end = Math.max(end, intervals.get(i).end);
			}
			else{
				res.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}
		res.add(new Interval(start, end));
		return res;
	}
}
