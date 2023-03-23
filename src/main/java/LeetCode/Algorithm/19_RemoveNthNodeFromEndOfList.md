[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
19. Remove Nth Node From End of List
## Approach
<!-- Describe your approach to solving the problem. -->
Maintain two pointers and update one with a delay of n steps.


## Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode right=head;   // right
        ListNode left=head; // left
        int size=0;

        while (true) {
            size++;
            if(right.next == null) break;

            right = right.next;
        }

      
        for(int i=0; i<((size-1)-n); i++) {
            left = left.next;
        }


        if(size==n) {
            head = left.next;
        }else if(left.next != null)
            left.next = left.next.next;
       
        return head;

    }
}
```