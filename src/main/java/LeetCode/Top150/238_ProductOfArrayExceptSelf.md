[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
238. Product of Array Except Self

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
/**
* 제외할 값을 기준으로 left, right를 나누어 누적곱 형태로 계산한다.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        
        left[0] = 1;
        right[n-1] = 1;
        for(int i=1; i<n; i++) {

            left[i] = left[i-1]*nums[i-1]; // left
            right[(n-1)-i] = right[n-i]*nums[n-i]; // right

        }

        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            ans[i] = left[i]*right[i];
        }

        return ans;
    }
}
```