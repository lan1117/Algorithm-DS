package 二刷;

public class Eightytwo_RemoveDuplicatesFromSortedListII {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	public ListNode deleteDuplicates(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while(cur != null){
			while(cur.next != null && cur.val== cur.next.val){
				cur = cur.next;
			}
			if(pre.next == cur){
				pre = pre.next;
			}
			else{
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}
