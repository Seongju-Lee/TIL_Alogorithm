[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
283. Move Zeroes
## Approach
<!-- Describe your approach to solving the problem. -->
**초기 접근 방식<br>**
li와 ri를 모두 0으로 초기화하고, 값을 비교해가면 교환 또는 유지를 순차적으로 진행.
<br>
효율이 매우 떨어짐. => Runtime 2ms

**변경한 접근 방식<br>**
결국 맨 끝에 n개의 0이 채워지면 되는 것이므로, 순차적으로 탐색하면서 0의 개수를 체크.<br>
0인 값이 나오면 count 증가, 0이 아닌 값이면 0번 인덱스부터 값을 덮어씌움.<br>

마지막에는 맨 끝 인덱스부터 count만큼 0을 채워넣음.


## Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public void moveZeroes(int[] nums) {

        
        int li=0, ri=nums.length-1;
        int count=0;

        for(int i=0; i<=ri; i++) {
            if(nums[i]!=0) {
                nums[li] = nums[i];
                li++;
            } else {
                count++;
            }
        }

        while (count > 0) {
            nums[ri] = 0;
            ri--;
            count--;
        }
    }
}
```
```