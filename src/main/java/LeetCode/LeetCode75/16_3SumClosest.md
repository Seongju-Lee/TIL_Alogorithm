[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
16. 3Sum Closest

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^2)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public int threeSumClosest(int[] nums, int target) {

        int ans = 0;
        int diff = 20_001;
        Arrays.sort(nums);

        // x+y+z => target을 x+y => (target-z)로 변경하면 투포인터 접근이 가능.
        for(int z=0; z<nums.length; z++) {


            int t = target-nums[z];
            int li=z+1, ri=nums.length-1;

            while (li < ri) {
                
                int sum = nums[li]+nums[ri];
                if(Math.abs(sum-t) < diff) {
                    diff=Math.abs(sum-t);
                    ans = sum+nums[z];
                    if(ans == t+nums[z]) {
                        return ans;
                    }
                }
                else if(sum < t) li++;
                else if(sum > t) ri--;

            }
        }

        return ans;
    }
}
```