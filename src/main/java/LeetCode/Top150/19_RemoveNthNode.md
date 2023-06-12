[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
19. Remove Nth Node From End of List

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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        

        if(n == 1 && head.next == null) return head.next;

        ListNode left = head;
        ListNode right = head;

        int cnt = 0;
        while (right.next != null) {
            cnt++;
            right = right.next;
        }
        
        cnt -= n;
        
        for(int i=0; i<cnt; i++) {
            left = left.next;
        }
       
        if(cnt < 0) {
            head = left.next;
        }else if(left.next != null)  // left.next 를 left.next.next로 변경.
            left.next = left.next.next;
            

        return head;
    }
}
```