package 二刷;

public class Two_AddTwoNumbers {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	public ListNode Add2Numbers(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null) return null;
		if(l1== null || l2 == null) return l1 == null ? l2 : l1;
		ListNode dummy = new ListNode(0);
		ListNode newHead = dummy;
		int carry = 0;
		while(l1 != null || l2 != null || carry != 0){
			carry += l1 == null ? 0 : l1.val;
			carry += l2 == null ? 0 : l2.val;
			int cur = carry % 10;
			carry /= 10;
			newHead.next = new ListNode(cur);
			newHead = newHead.next;
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		return dummy.next;
	}
}
