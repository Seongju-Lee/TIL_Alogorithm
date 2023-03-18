[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
704. Binary Search
## Approach
<!-- Describe your approach to solving the problem. -->
이진탐색을 이용하여 target 탐색.

## Complexity
- Time complexity: O(logN)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        
        int li=0, ri=nums.length-1;
        int answer = -1;
        
        while (li <= ri) {
            int mi = (li+ri)/2;

            if(nums[mi] == target) {
                answer = mi;
                break;
            } else if(nums[mi] < target) {
                li = mi+1;
            } else {
                ri = mi-1;
            }
        }

        return answer;
    }
}
```