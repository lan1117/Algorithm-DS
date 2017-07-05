package 二刷;
import java.util.*;
public class Onethirtyeight_CopyListWithRandomPointer {
	class RandomListNode{
		int label;
		RandomListNode next, random;
		RandomListNode(int x){
			this.label = x;
		}
	}
	public RandomListNode copyRandomList(RandomListNode head){
		if(head == null) return null;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode cur = dummy;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		while(head != null){
			if(!map.containsKey(head)){
				map.put(head, new RandomListNode(head.label));
			}
			cur.next = map.get(head);
			if(head.random != null){
				if(!map.containsKey(head.random)){
					map.put(head.random, new RandomListNode(head.random.label));
				}
				cur.next.random = map.get(head.random);
			}
			head = head.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}
