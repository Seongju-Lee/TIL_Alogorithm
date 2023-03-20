[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
977. Squares of a Sorted Array
## Approach
<!-- Describe your approach to solving the problem. -->
two pointer 알고리즘을 이용하여 O(n)으로 해결 가능.<br>
새로운 배열을 선언하고, 제곱이 큰 값순으로 가장 오른쪽부터 채워간다.<br>

li위치의 값이 더 크면 li만 증가 or ri 위치의 값이 더 크면 ri만 감소하는 형태로 two pointer 알고리즘 활용.


## Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int li = 0;
        int ri = nums.length-1;
        int ci = nums.length-1;
        int[] answer = new int[nums.length];

        while (li <= ri) {
            
            if(Math.abs(nums[li]) < Math.abs(nums[ri])) {
                answer[ci--] = nums[ri]*nums[ri];
                ri--;
            } else {
                answer[ci--] = nums[li]*nums[li];
                li++;
            }
        }

        return answer;
    }
}
```
```