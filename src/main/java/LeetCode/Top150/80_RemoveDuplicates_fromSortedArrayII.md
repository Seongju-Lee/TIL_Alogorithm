[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
80. Remove Duplicates from Sorted Array II

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
        int cnt = 1;
        while (ri != nums.length) {

            if(nums[ri] == nums[ri-1]) { // 연속된 수
                cnt++; // 카운트 증가
            } else {
                cnt = 1; // 아니라면, 카운트 초기화
            }

            //== 바꾸기 직전에 li는 멈췄다가 간다. ==// -> keyPoint
            if(cnt <= 2) { 
                nums[li] = nums[ri];
                li++;
            }
            ri++;
        }

     
        return li;
    }
}
```