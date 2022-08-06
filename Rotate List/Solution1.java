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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        System.out.println(length);
        k %= length;
        if (k == 0) {
            return head;
        }
        int headIndex = length - k;
        ListNode temp2 = head;
        ListNode prev = null;
        for (int i = 0; i < headIndex; i++) {
            prev = temp2;
            temp2 = temp2.next;
            
        }
        
        prev.next = null;
        ListNode temp3 = temp2;
        while (temp3.next != null) {
            temp3 = temp3.next;
        }
        temp3.next = head;
        return temp2;
    }
}
