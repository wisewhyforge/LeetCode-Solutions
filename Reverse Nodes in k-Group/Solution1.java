/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if (nextHead == null) {
                return head;
            }
            nextHead = nextHead.next;
            
        }
        ListNode prev = nextHead;
        ListNode cur = head;
        ListNode ans = null;
        ListNode prevHead = cur;
        
        while (cur != nextHead) {
            if (cur.next == nextHead) {
                ans = cur;
            }
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        while (true) {
            for (int i = 0; i < k; i++) {
                if (nextHead == null) {
                    return ans;
                }
                nextHead = nextHead.next;
            }
            
            prev = nextHead;
            ListNode prevHead2 = cur;
            while (cur != nextHead) {
                if (cur.next == nextHead) {
                    prevHead.next = cur;
                    prevHead = prevHead2;
                }
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
        }
        
    }
}
