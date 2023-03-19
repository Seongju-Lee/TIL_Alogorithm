[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
35. Search Insert Position
## Approach
<!-- Describe your approach to solving the problem. -->
target을 찾음과 동시에 target값이 존재하지 않으면, 삽입할 위치를 정하는 문제.

## Complexity
- Time complexity: O(logN)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class Solution {
    public int searchInsert(int[] nums, int target) {

        int li=0, ri=nums.length-1;
        while (li <= ri) {

            int mid = (li+ri)/2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                ri = mid-1;
            } else {
                li = mid+1;
            }

        }
        return ri+1;
    }
}
```