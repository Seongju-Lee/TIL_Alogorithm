[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
209. Minimum Size Subarray Sum


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
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int answer = Integer.MAX_VALUE;

        int li=0, ri=0;
        int sum = 0;
        while (ri != nums.length) {

            sum += nums[ri];

            while (sum >= target) {

                answer = Math.min(answer, (ri-li)+1);
                sum -= nums[li]; 
                li++;
            }

            
            ri++;
        }



        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
```