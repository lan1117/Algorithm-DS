package 二刷;
import java.util.*;
public class ThreeFourtysix_MovingAverageFromDataStream {
	int sum;
	int k;
	Queue<Integer> queue;
	public ThreeFourtysix_MovingAverageFromDataStream(int size){
		this.k = size;
		this.sum = 0;
		queue = new LinkedList<>();
	}
	public double next(int val){
		if(queue.size() == k){
			sum = sum - queue.poll();
		}
		sum += val;
		queue.offer(val);
		return sum / queue.size();
	}
}
