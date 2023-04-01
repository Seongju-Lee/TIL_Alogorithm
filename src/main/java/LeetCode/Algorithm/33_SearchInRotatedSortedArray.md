[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
33. Search in Rotated Sorted Array
## Approach
<!-- Describe your approach to solving the problem. -->
이분탐색을 하되, target 값의 대소비교를 하는 것이 아닌 문제였다.  
**target의 범위**를 비교해 나아가는 이분탐색 응용 문제.

## Complexity
- Time complexity: O(logN)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int search(int[] nums, int target) {
        
        // middle 인덱스 기준으로 해서 왼쪽에 target 값이 범위 내 라면 ri를 왼쪽으로.
        // 왼쪽에 target값이 범위 밖이라면 li를 오른쪽으로.
        
        int li=0, ri=nums.length-1; // li: 왼쪽 인덱스, ri: 오른쪽 인덱스
        
        
        while (li <= ri) {

            int mid = (li+ri)/2; // 비교 기준이 될 중간값
            if(nums[mid] == target) return mid;

            if(nums[li] <= nums[mid]) {

                if(target >= nums[li] && target < nums[mid]) {
                    ri = mid-1;
                }else {
                    li = mid+1;
                }
            } else {

                if(target <= nums[ri] && target > nums[mid]) {
                    li = mid+1;
                } else {
                    ri = mid-1;
                }
            }
        }


        return -1;

        
    }
}
```