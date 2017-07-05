package 二刷;
import java.util.*;
public class TwoFiftyone_Flatten2DVector implements Iterator<Integer>{
	private Iterator<List<Integer>> i;
	private Iterator<Integer> j;
	
	public TwoFiftyone_Flatten2DVector(List<List<Integer>> vec2d){
		i = vec2d.iterator();
	}
	@Override
	public Integer next(){
		hasNext();
		return j.next();
	}
	@Override
	public boolean hasNext(){
		while((j == null || !j.hasNext()) && i.hasNext()){
			j = i.next().iterator();
		}
		return j != null && j.hasNext();
	}
}
