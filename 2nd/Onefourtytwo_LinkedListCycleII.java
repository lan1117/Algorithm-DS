package 二刷;

public class Onefourtytwo_LinkedListCycleII {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	public ListNode detectCycle(ListNode head){
		if(head == null) return null;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				ListNode node = head;
				while(slow != node){
					slow = slow.next;
					node = node.next;
				}
				return node;
			}
		}
		return null;
	}
}
