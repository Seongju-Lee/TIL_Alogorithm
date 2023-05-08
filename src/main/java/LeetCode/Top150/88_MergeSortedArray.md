[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
88. Merge Sorted Array

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
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int idx1=(m-1), idx2=(n-1);
        int k=(m+n)-1; // 뒤에서부터 삽입하기 위함

        while(idx2 >= 0) { // idx2 다 삽입하면 끝

            // idx1 >= 0: nums1배열에 비교할 요소가 있는 지 판단
            if( idx1 >= 0 && nums1[idx1] > nums2[idx2]) {
                nums1[k--] = nums1[idx1--];
            } else {
                nums1[k--] = nums2[idx2--];
            }
        }
        

    }
}
```