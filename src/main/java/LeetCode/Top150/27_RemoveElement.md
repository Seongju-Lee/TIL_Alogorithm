[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
27. Remove Element

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
    public int removeDuplicates(int[] nums) {
        
        int li=1, ri=1;
        while (ri != nums.length) {
            
            // ri와 ri-1 비교하면서, 다른 값나오는 순간
            // li에 ri 넣고, li++
            if(nums[ri] != nums[ri-1]) {
                nums[li] = nums[ri];
                li++;
            }

            ri++;
        }

        return li;
    }
}
```