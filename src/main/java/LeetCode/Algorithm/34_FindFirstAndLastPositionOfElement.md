[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
34. Find First and Last Position of Element in Sorted Array
## Approach
<!-- Describe your approach to solving the problem. -->
Maintain two pointers and update one with a delay of n steps.


## Complexity
- Time complexity: O(n)
<br> Two Pointer를 이용하여 O(n)의 시간복잡도로 풀이하였다.
<br> 주어진 입력 범위를 보았을 때, TLE는 발생 안할 것이라 확신했지만,
<br> 이분탐색을 이용해서 target의 최소인덱스, 최대인덱스를 구하는 방식으로 재풀이 필요.
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        // Arrays.sort(nums); // 두 포인터를 위해 정렬. O(logN)
        
        int li=0, ri=nums.length-1; // li: 왼쪽 포인터, ri: 오른쪽 포인터
        
        boolean lFlag=false, rFlag=false; // lFlag: 왼쪽 발견 시 정지, rFlag: 오른쪽 발견시 정지

        while (li <= ri) {
            
            if(!lFlag) {
                if(nums[li] == target) {
                    lFlag = true;
                } else {
                    li++;
                }
            }

            if(!rFlag) {
                if(nums[ri] == target) {
                    rFlag = true;
                } else {
                    ri--;
                }
            }

            if(lFlag && rFlag) {
                return new int[]{li, ri};
            }
        } 

        
        return new int[]{-1, -1};
    }
}
```