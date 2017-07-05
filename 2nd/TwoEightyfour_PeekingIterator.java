package 二刷;
import java.util.*;
public class TwoEightyfour_PeekingIterator implements Iterator<Integer>{
	Integer next;
	Iterator<Integer> it;
	public TwoEightyfour_PeekingIterator(Iterator<Integer> iterator){
		it = iterator;
		if(it.hasNext()){
			next = it.next();
		}
	}
	public Integer peek(){
		return next;
	}
	@Override
	public Integer next(){
		Integer num = next;
		next = it.hasNext() ? it.next() : null;
		return num;
	}
	@Override
	public boolean hasNext(){
		return it.hasNext() || next != null;
	}
}
