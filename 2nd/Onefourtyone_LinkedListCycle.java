package 二刷;

public class Onefourtyone_LinkedListCycle {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode head){
		if(head == null || head.next == null) return false;
		ListNode fast, slow;
		fast = head.next;
		slow = head;
		while(fast != slow){
			if(fast == null || fast.next == null){
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
	}
}
