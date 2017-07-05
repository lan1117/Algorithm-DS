package 二刷;

public class Onefourtyeight_SortList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	public ListNode sortList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode pre = null, slow = head, fast = head;
		while(fast != null && fast.next != null){
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode low = sortList(head);
		ListNode high = sortList(slow);
		return merge(low, high);
	}
	public ListNode merge(ListNode low, ListNode high){
		ListNode head = new ListNode(0), cur = head;
		while(low != null && high != null){
			if(low.val < high.val){
				cur.next = low;
				low = low.next;
			}else{
				cur.next = high;
				high = high.next;
			}
			cur = cur.next;
		}
		if(low != null){
			cur.next = low;
		}
		if(high != null){
			cur.next = high;
		}
		return head.next;
	}
}
