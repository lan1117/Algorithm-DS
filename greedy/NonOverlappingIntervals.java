package greedy;

import java.util.Arrays;

/*
 * Given a collection of intervals, 
 * find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {
	public class Interval{
		int start;
		int end;
		Interval(){start = 0; end = 0;}
		Interval(int s, int e){start = s; end = e;}
	}
	public int eraseOverlapIntervals(Interval[] intervals){
		if(intervals == null || intervals.length == 0){
			return 0;
		}
		Arrays.sort(intervals,(a,b) -> a.start - b.start);
		int end = intervals[0].end;
		int n = intervals.length;
		int res = 0;
		for(int i = 1; i < n; i ++){
			if(end > intervals[i].start){
				end = Math.min(end, intervals[i].end);
				res++;
			}
			else{
				end = intervals[i].end;
			}
		}
		return res;
	}
}
