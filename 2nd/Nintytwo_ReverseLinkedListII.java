package 二刷;

public class Nintytwo_ReverseLinkedListII {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	public ListNode reverseBetwwen(ListNode head, int m, int n){
		if(head == null)
			return null;
		ListNode d = new ListNode(0);
		d.next = head;
		ListNode start = d;
		ListNode cur = head;
		for(int i = 1; i < m; i++){
			start = start.next;
			cur = cur.next;
		}
		for(int i = m; i < n && cur != null; i++){
			ListNode mv = cur.next;
			cur.next = cur.next.next;
			mv.next = start.next;
			start.next = mv;
		}
		return d.next;
	}
}
