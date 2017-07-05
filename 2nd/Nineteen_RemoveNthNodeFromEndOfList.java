package 二刷;

public class Nineteen_RemoveNthNodeFromEndOfList {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){val = x;}
	}
	public ListNode removeNthFromEnd(ListNode head, int n){
		//Insert a new node at the beginning of the list
		//avoid the situation when the first node is to be deleted
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode fast = newHead;
		ListNode slow = newHead;
		while(n>0){
			fast = fast.next;
			n--;
		}
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return newHead.next;
	}
}
