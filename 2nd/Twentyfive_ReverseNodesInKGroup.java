package 二刷;

public class Twentyfive_ReverseNodesInKGroup {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	public ListNode reverseKGroup(ListNode head, int k){
		if(head == null || k == 1 || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode start = dummy;
		int idx = 0;
		while(head != null){
			idx++;
			if(idx % k == 0){
				start = reverse(start, head.next);
				head = start.next;
			}
			else{
				head = head.next;
			}
		}
		return dummy.next;
	}
	public ListNode reverse(ListNode start, ListNode end){
		ListNode pre = end;
		ListNode first = start.next;
		ListNode cur = start.next;
		while(cur != end){
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		start.next = pre;
		return first;
	}
}
