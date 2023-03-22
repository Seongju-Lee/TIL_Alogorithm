[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
344. Reverse String
## Approach
<!-- Describe your approach to solving the problem. -->
Two-Pointer


## Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public void reverseString(char[] s) {
        
        int li=0, ri=s.length-1;
        while (li < ri) {

            char tmp = s[ri];
            s[ri] = s[li];
            s[li] = tmp;

            li++;
            ri--;
        }
    }
}
```