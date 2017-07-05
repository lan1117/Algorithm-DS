package 二刷;
import java.util.*;
public class TwoThirtynine_SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k){
		if(nums == null || nums.length < k || k <= 0) return new int[0];
		int idx = 0;
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 0; i < nums.length; i++){
			inQueue(deque, nums[i]);
			if(i >= k - 1){
				res[idx++] = deque.peekFirst();
				outQueue(deque, nums[i-k+1]);
			}
		}
		return res;
	}
	public void inQueue(Deque<Integer> deque, int num){
		while(!deque.isEmpty() && num > deque.peekLast()){
			deque.pollLast();
		}
		deque.offerLast(num);
	}
	public void outQueue(Deque<Integer>deque, int num){
		if(num == deque.peekFirst()){
			deque.pollFirst();
		}
	}
}
