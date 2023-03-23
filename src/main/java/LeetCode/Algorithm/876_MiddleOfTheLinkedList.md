[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
876. Middle of the Linked List
## Approach
<!-- Describe your approach to solving the problem. -->
two pointers를 사용.<br>
size를 구할 수 있는 상태가 아니기 때문에, 중간 인덱스를 알 수 없다.<br>
중간 인덱스를 구하기 위해 하나의 포인터는 두칸씩(right) 이동 / 또 다른 포인터는 한칸씩(left) 이동<br>
right가 더 이상 이동할 곳이 없을 때의 left 위치가 중간 인덱스다.

짝수 개의 List라면, left+1을 하여 마무리 한다.

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
    public ListNode middleNode(ListNode head) {

        ListNode left=head;
        ListNode right=head;

        while (head.next != null) {

            if(right.next == null) break;
            else if(right.next.next==null){
                left = left.next;
                break;
            }
            else{
                right = right.next.next;
                left = left.next;
            }
        }

        return left;
    }
}
```