[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
189. Rotate Array
## Approach
<!-- Describe your approach to solving the problem. -->
two pointer 알고리즘을 활용하는 방식.<br>
결국에는 뒤에 k개의 값들을 앞으로 옮기면 끝나는 형태이다. <br>

초기 접근했던 방식은 아래와 같다.<br>
<img src="https://user-images.githubusercontent.com/67941526/226265752-c01b38ff-b3ca-4ea6-811e-dc9d6dd975c4.png" width="400" height="200">

위 방식의 문제점은 **홀수개의 배열에서 값 하나가 남는 것**이었다.<br>
Collection을 활용하여 쉽게 값을 맨 끝으로 옮겨도 되나, 가능한 배열로 처리하고 싶었다.<br>

아래와 같은 방식으로 최종 처리<br>
<img src="https://user-images.githubusercontent.com/67941526/226265459-6f4722f8-1bfa-47f6-aafe-d5c2ea11a8c3.png" width="400" height="200"><br>
**뒤에 k개를 기준으로 하여, 두 포지션으로 나누고 각 포지션의 값들을 교환 후, 전체의 값을 교환하면 끝나는 형태.**

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
