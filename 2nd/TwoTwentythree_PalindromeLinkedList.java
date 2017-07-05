package 二刷;

public class TwoTwentythree_PalindromeLinkedList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	public boolean isPalindrome(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast != null){
			slow = slow.next;
		}
		slow = reverse(slow);
		while(slow != null && slow.val == head.val){
			slow = slow.next;
			head = head.next;
		}
		return slow == null;
	}
	public ListNode reverse(ListNode head){
		ListNode pre = null;
		ListNode cur = head;
		while(head != null){
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}
}
