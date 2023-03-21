[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
167. Two Sum II - Input Array Is Sorted
## Approach
<!-- Describe your approach to solving the problem. -->
**초기 접근 방식(Binary Search)<br>**
li를 고정시켜놓고, (li+1)~ri까지 (target-nums[li]) 값을 이분탐색.<br>
TLE를 방지하고자 이분탐색을 진행했으나,O(nlog(n))의 시간복잡도로 해당 문제에서는 5ms라는 결과.

**변경한 접근 방식(Two Pointer)<br>**
li와 ri를 각각 처음과 끝 인덱스로 설정.<br>
각 인덱스의 위치한 값을 더한값과 target을 비교해서 각 상황에 맞게 인덱스 조절.


## Complexity
- Time complexity: O(nlogn) -> Binary Search
- Time complexity: O(n)     -> Two Pointer
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int li=0, ri=numbers.length-1;
        int[] answer = new int[2];

        while (li < ri) {

            if(numbers[li]+numbers[ri] == target) {
                answer[0] = (li+1);
                answer[1] = (ri+1);
                break;
            }
            else if(numbers[li]+numbers[ri] > target) ri--;
            else li++;
        }

        return answer;
    }
}
```
```