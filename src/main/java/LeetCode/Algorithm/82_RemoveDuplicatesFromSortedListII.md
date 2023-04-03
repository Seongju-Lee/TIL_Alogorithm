[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
82. Remove Duplicates from Sorted List II
## Approach
<!-- Describe your approach to solving the problem. -->
중복된 값을 제거하기 위해 투 포인터를 이용해서 순차탐색 진행.  
빈 ListNode 클래스를 만들어, 기존의 값들을 비교하면서 값을 추가하는 형태로 진행.


## Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
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
    public ListNode deleteDuplicates(ListNode head) {
        

        ListNode ln = new ListNode();
        ListNode rn = head; // 오른쪽 노드가 head부터 탐색 시작
        ln.next = rn; // 왼쪽 노드는 일단 비어두고, 다음노드를 head로 이어줌.

        head = ln;
        boolean flag = false; // ln을 움직일지 말지 결정할 boolean
        if(rn == null) return head.next;

        while (rn.next != null) {

            if(rn.val == rn.next.val) {
                rn = rn.next;
                flag = true;
            } else {

                if(!flag) {
                    rn = rn.next;
                    ln = ln.next;
                } else {
                    rn = rn.next;
                    ln.next = rn;
                    flag = false;
                }

            }
        }

        if(flag)
            ln.next = null;

        return head.next;


        
    }
}
```