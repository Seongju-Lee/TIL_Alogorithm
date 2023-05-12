[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
55. Jump Game

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^2) dfs
- Time complexity: O(n) greedy

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public boolean dfs(int[] nums, int idx) {

        if(idx+nums[idx] >= nums.length-1) {
            return true;
        } else if(nums[idx] == 0) return false;

        int maxIdx=idx, max=0;
        for(int i=idx+1; i<=(idx+nums[idx]); i++) {
            if(nums[i]+i > max) {
                maxIdx = i;
                max = nums[i]+i;
            }
        }

        if(dfs(nums, maxIdx)) return true;
        else return false;
    }

    public boolean canJump(int[] nums) {
        
        return dfs(nums, 0);
                
    }
}
```
```
class Solution {
    public boolean canJump(int[] nums) {
        // 목적지에 가까운 곳부터 처리할 수 있다. -> Greedy

        int target = nums.length-1;
        int idx = target-1;

        while (idx >= 0) {

            if(nums[idx]+idx >= target) {
                target = idx; // target에 도달 가능한 위치라면, target을 현재 위치로 switch
            }

            idx--; // idx는 계속 내린다.

        }

        if(target <= 0) return true;
        else return false;
    }
}
```