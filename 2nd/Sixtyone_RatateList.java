package 二刷;

public class Sixtyone_RatateList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	public ListNode rotateRight(ListNode head, int k){
		if(head == null || head.next == null) return head;
		int len = 1;
		ListNode end = head;
		while(end.next != null){
			end = end.next;
			len++;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode start = dummy;
		int idx = len - k % len;
		for(int i = 0; i < idx; i++){
			start = start.next;
		}
		end.next = dummy.next;
		dummy.next = start.next;
		start.next = null;
		return dummy.next;
		/*ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy.next;
		while(k > 0){
			cur = cur.next;
			k--;
		}
		cur.next = null;
		ListNode n1 = dummy.next;*/
		
	}
}
