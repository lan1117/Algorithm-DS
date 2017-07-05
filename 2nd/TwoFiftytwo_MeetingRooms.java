package 二刷;
import java.util.*;
public class TwoFiftytwo_MeetingRooms {
	class Interval{
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e){start = s; end = e;}
	}
	public boolean canAttendMeetings(Interval[] intervals){
		if(intervals == null) return false;
		Comparator<Interval> cmp = new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		};
		Arrays.sort(intervals, cmp);
		for(int i = 0; i < intervals.length - 1; i++){
			int end = intervals[i].end;
			int start = intervals[i+1].start;
			if(end > start){
				return false;
			}
		}
		return true;
	}
}
