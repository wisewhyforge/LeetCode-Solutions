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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        ListNode offset = head;
        for (int i = 0; i < length / 2; i++) {
            offset = offset.next;
        }
        ListNode reverse = reverse(head, offset);
        if (length % 2 != 0) {
            offset = offset.next;
        }
        
        while (offset != null) {
            if (offset.val != reverse.val) {
                return false;
            }
            
            offset = offset.next;
            reverse = reverse.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        
        while (cur != end) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}
