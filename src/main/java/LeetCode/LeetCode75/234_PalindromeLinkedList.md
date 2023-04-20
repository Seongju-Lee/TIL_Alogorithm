[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
234. Palindrome Linked List

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(N)

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
    public boolean isPalindrome(ListNode head) {
        
        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            cnt++;
            list.add(head.val);
            head = head.next;
        }

        int left = (cnt/2)-1, right = cnt/2;
        if(cnt%2 == 1) {
            right += 1;
        }

        boolean ans = true;
        while (left >= 0 && right < list.size()) {

            if(list.get(left) != list.get(right)) {
                return false;
            }
            left--;
            right++;

        }

        return true;
    }
}
```