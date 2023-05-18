[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
42. Trapping Rain Water

[//]: # (## Approach)

[//]: # ()
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
    public int trap(int[] height) {
        
        int n = height.length;

        //== 0번과 마지막 값은 0 ==//
        int[] ans = new int[n];


        // 왼쪽에서 이동
            // 최대 높이를 가지고 (최대 높이-현재높이)를 값으로 치환
            // 값<0(최대높이보다 현재높이가 큰 경우) 이면, 최대높이=현재높이 하고, 값은 0

        int maxHeight = height[0];
        for (int i=1; i<(n-1); i++) {
            
            if(maxHeight < height[i]) { // 지금까지의 최대높이보다 더 큰 높이라면 업데이트
                maxHeight = height[i];
                ans[i] = 0;
            } else {
                ans[i] = (maxHeight-height[i]); // 최대높이와 비교하여 현재 위치가 담을 수 있는 물의 양
            }
        }

        maxHeight = height[n-1]; // 오른쪽 -> 왼쪽으로 이동
        for(int i=(n-2); i>=1; i--) {

            if(maxHeight < height[i]) {
                maxHeight = height[i];
                ans[i] = 0;
                continue;
            }

            ans[i] = Math.min(ans[i], maxHeight-height[i]);
        }
        

        int sum=0;
        for(int i : ans) {
            sum += i;
        }

        return sum;

    }
}
```