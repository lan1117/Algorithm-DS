package 二刷;
import java.util.*;

public class Twentythree_MergeKSortedLists {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	public ListNode merge(ListNode[] lists){
		if(lists == null || lists.length == 0) return null;
		Comparator<ListNode> cmp = new Comparator<ListNode>(){
			@Override
			public int compare(ListNode l1, ListNode l2){
				return l1.val - l2.val;
			}
		};
		Queue<ListNode> heap = new PriorityQueue<>(cmp);
		for(ListNode head : lists){
			if(head != null){
				heap.offer(head);
			}
		}
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		while(!heap.isEmpty()){
			ListNode node = heap.poll();
			cur.next = node;
			cur = cur.next;
			if(node.next != null){
				heap.offer(node.next);
			}
		}
		return newHead.next;
	}
}
