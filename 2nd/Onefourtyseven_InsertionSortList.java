package 二刷;

public class Onefourtyseven_InsertionSortList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	//1 6 2 5 3 4
	//0
	public ListNode insertionSortList(ListNode head){
		ListNode newHead = new ListNode(0);
		ListNode pre = newHead;
		ListNode next = null;
		ListNode cur = head;
		while(cur != null){
			pre = newHead;
			next = cur.next;
			while(pre.next != null && pre.next.val < cur.val){
				pre = pre.next;
			}
			cur.next = pre.next; //1 -> null //6 -> null
			pre.next = cur; //0 -> 1 -> null //0 -> 1 -> 6 -> null
			cur = next; //6 //2
		}
		return newHead.next;
	}
}
