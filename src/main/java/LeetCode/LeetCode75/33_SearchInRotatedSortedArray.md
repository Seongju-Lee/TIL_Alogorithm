[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
33. Search in Rotated Sorted Array

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(log(n))

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public int search(int[] nums, int target) {
        
        
        int li = 0;
        int ri = nums.length-1;

        if(li == ri) return (nums[0] == target)? 0 : -1;


        // nums 특성 상, nums[li]가 nums[mi] 보다 작으면, li~mid까지의 값들이 오름차순일 수 밖에 없다.
        // 반대로, nums[ri]가 nums[mi] 보다 크면, mid~ri까지의 값들이 오름차순일 수밖에 없다.
        // 그리고, nums는 오름차순이었던 배열이 회전한 것이므로 위 두 조건 중 하나는 만족할 수 밖에 없다.
        // (= 어느 한쪽은 무조건 오름차순이게 되어있다.)
        while (li <= ri) {

            int mi = (li+ri)/2;
            
            if(nums[mi] == target) return mi;

            // 왼쪽을 기준으로 조건 비교. nums[li]가 nums[mi] 보다 작으면, li~mid까지의 값들이 오름차순
            if(nums[mi] >= nums[li]) {
                if(nums[li] <= target && target < nums[mi]) {
                    ri = mi-1;
                } else 
                    li = mi+1;
            } else { // 그게 아니라면, 무조건 오른쪽이 오름차순인 상태.
            
                if(nums[mi] < target && target <= nums[ri]) {
                    li = mi+1;
                } else {
                    ri = mi-1;
                }

            }
        }


        return -1;

    }
}
```