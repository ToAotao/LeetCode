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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;
        for (ListNode node : lists) {
            if (node != null){
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            cursor.next = node;
            cursor = cursor.next;
            if(node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}