[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
1. Two Sum

[//]: # (## Approach)

[//]: # ()
[//]: # (<!-- Describe your approach to solving the problem. -->)

## Complexity

- Time complexity: O(2*n) : sliding window
- Time complexity: O(n) : mapping

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
/* sliding window */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        

        // target 보다 작을 때까지 ri 이동하면서 더함.
        // target 보다 크다면, li만 이동하면 됨.

        int li = 0, ri = 1;
        int sum = nums[0]+nums[1];
        while (sum != target)  {


            if(ri == nums.length) {
                sum = 0;
                li++;
                ri = li+1;

                sum += nums[li];
                sum += nums[ri];
            }

            else {
                
                sum -= nums[ri];
                ri++;
                if(ri == nums.length) continue;

                sum += nums[ri];

            }

        }

     
        return new int[]{li, ri};

        
    }
}
```
```
/* map */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        

        int[] ans = new int[2];
        
        // 현재 값을 map에 저장 (map: {값, 인덱스})
        Map<Integer, Integer> map = new HashMap<>();


        // target-현재값이 map에 있다면, 그 map에 저장된 인덱스와 현재값의 인덱스를 답으로 도출
        for (int i=0; i<nums.length; i++) {

            if(map.containsKey(target - nums[i])) {
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return ans;

    }
}
```
