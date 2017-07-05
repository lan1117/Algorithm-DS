package 二刷;
import java.util.*;
public class TwoTwentyfive_ImplementStackUsingQueue {
	Queue<Integer> queue;
	public TwoTwentyfive_ImplementStackUsingQueue(){
		queue = new LinkedList<>();
	}
	public void push(int x){
		queue.offer(x);
		int size = queue.size();
		for(int i = 0; i < size - 1; i++){
			queue.offer(queue.poll());
		}
	}
	public int pop(){
		return queue.poll();
	}
	public int top(){
		return queue.peek();
	}
	public boolean empty(){
		return queue.isEmpty();
	}
}
