[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
328. Odd Even Linked List

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
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {

        ListNode lHead = new ListNode(); // 홀수 연결리스트의 헤드
        ListNode rHead = new ListNode(); // 짝수 연결리스트의 헤드

        if(head == null || head.next == null) return head; // 주어진 head의 길이가 1 또는 0 인 경우 

        ListNode left = head; // 초기 홀수 노드
        ListNode right = head.next; // 초기 짝수 노드

        lHead.next = left;
        rHead.next = right;

        while (left.next != null && right.next != null) {
            
            left.next = right.next; // 현재 홀수 노드가 다음 홀수노드를 가리키도록 연결.
            right.next = right.next.next; // 현재 짝수 노드가 다음 짝수노드를 가리키도록 연결.

            left = left.next;
            right = right.next;

        }

        left.next = rHead.next;
        return lHead.next;
       
    }
}
```