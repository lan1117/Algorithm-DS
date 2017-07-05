package 二刷;
import java.util.*;

public class Fiftyseven_InsertInterval {
	class Interval{
		int start;
		int end;
		Interval(){start = 0; end = 0;}
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> res = new ArrayList<>();
        int n = intervals.size();
        int i = 0;
        // Add all the interval end before new interval
        while(i < n && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i++));
        }
        // Merge all the interval overlapped
        while(i < n && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        res.add(newInterval);
        while(i < n)
            res.add(intervals.get(i++));
        return res;
	}
}
