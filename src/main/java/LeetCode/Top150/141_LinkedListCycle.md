[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
141. Linked List Cycle



[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
}
```