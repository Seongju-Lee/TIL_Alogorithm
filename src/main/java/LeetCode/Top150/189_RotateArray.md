[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
189. Rotate Array

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(2n+k)
- Time complexity: O(n)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k %= n;
        int[] tmp = new int[n-k];

        // 0 ~ (n-(k+1))까지 tmp[]에 저장
        for(int i=0; i<=(n-(k+1)); i++) {
            tmp[i] = nums[i];
        }

        // (n-k) ~ (n-1)까지를 nums 0 부터 차례로 삽입
        int idx = 0;
        for(int i=(n-k); i<n; i++) {
            nums[idx++] = nums[i];
        }

        // 나머지 tmp 삽입 
        for (int t : tmp) {
            nums[idx++] = t;
        }
    

    }
}
```
```

class Solution {

    int[] switchValue(int li, int ri, int[] nums) {
        while(li < ri) {
            int tmp = nums[ri];
            nums[ri] = nums[li];
            nums[li] = tmp;

            li++;
            ri--;
        }

        return nums;
    }
    public void rotate(int[] nums, int k) {
        

        k %= nums.length;
        
        // 0~(length-1-k) ==> two pointer
        nums = switchValue(0, nums.length-k-1, nums);

        // (length-k) ~ (length-1) ==> two pointer
        nums = switchValue(nums.length-k, nums.length-1, nums);

        // 0 ~ (length-1) ==> two pointer
        nums = switchValue(0, nums.length-1, nums);

    }
}
```