/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode nodeMPre = vhead, nodeM = null, p=head;
        int i = 0;
        while(p != null) {
        	i++;
        	if(i < m) {
        		p = p.next;
        		nodeMPre = nodeMPre.next;
        	} else if(i==m) {
        		nodeM = p;
        		p = p.next;
        	} else if(i > m && i <= n) {
        		nodeM.next = p.next;
        		p.next = nodeMPre.next;
        		nodeMPre.next = p;
        		p = nodeM.next;
        	} else {
        		break;
        	}
        }
        return vhead.next;
    }
}
