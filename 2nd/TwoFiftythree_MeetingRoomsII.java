package 二刷;
import java.util.*;
public class TwoFiftythree_MeetingRoomsII {
	class Interval{
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e){start = s; end = e;}
	}
	public int minMeetingRooms(Interval[] intervals){
		if(intervals == null || intervals.length == 0) return 0;
		Comparator<Interval> cmp = new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		};
		Arrays.sort(intervals, cmp);
		Comparator<Interval> cmp2 = new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.end - i2.end;
			}
		};
		PriorityQueue<Interval> heap = new PriorityQueue<Interval>(cmp2);
		heap.offer(intervals[0]);
		for(int i = 1; i < intervals.length; i++){
			Interval inter = heap.poll();
			if(inter.end <= intervals[i].start){
				inter.end = intervals[i].end;
			}
			else{
				heap.offer(intervals[i]);
			}
			heap.offer(inter);
		}
		return heap.size();
	}
}
