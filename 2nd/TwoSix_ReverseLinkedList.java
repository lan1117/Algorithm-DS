package 二刷;

public class TwoSix_ReverseLinkedList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	public ListNode reverseList(ListNode head){
		ListNode newHead = null;
		while(head != null){
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}
