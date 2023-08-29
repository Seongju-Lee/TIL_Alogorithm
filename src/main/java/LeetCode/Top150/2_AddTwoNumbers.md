[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
2. Add Two Numbers


## Approach
- isRound를 통해, 올림 여부를 판단한다.


[//]: # ()
[//]: # (<!-- Describe your approach to solving the problem. -->)

## Complexity

- Time complexity: O(n)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode realAns = ans;
        boolean isRound = false;

        while (l1 != null && l2 != null) {
            int addVal = l1.val + l2.val;
            if(isRound) {
                addVal += 1;
                isRound = false;
            }
            ans.next = new ListNode((addVal%10));
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;

            if(addVal >= 10) {
                isRound = true;
            }
        }

        while (l1 != null) {
            int val = l1.val;
            if(isRound) {
                val += 1;
                isRound = false;
            }
            ans.next = new ListNode(val%10);
            ans = ans.next;
            l1 = l1.next;
            if(val >= 10) {
                isRound = true;
            }
        }

        while (l2 != null) {
            int val = l2.val;
            if(isRound) {
                val += 1;
                isRound = false;
            }
            ans.next = new ListNode(val%10);
            ans = ans.next;
            l2 = l2.next;
            if(val >= 10) {
                isRound = true;
            }
        }

        if(isRound) {
            ans.next = new ListNode(1);
        }
        return realAns.next;
    }
}
```
