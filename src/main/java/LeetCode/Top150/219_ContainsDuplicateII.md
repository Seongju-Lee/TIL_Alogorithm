[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
219. Contains Duplicate II



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

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {

            // 이미 포함 되어 있고, 범위가 k이내일 때
            if(map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                return true;
            } 
            // map 안에 이미 있는 원소여도 가장 마지막 인덱스로 mapping정보 업데이트
            map.put(nums[i], i);
        }
        return false;

    }
}
```