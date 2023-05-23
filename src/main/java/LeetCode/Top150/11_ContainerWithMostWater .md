[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
11. Container With Most Water

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
    public int maxArea(int[] height) {
        
        // 어차피 하나 줄어들 때, 
            // 왼쪽이 이동하던, 오른쪽이 이동하던 x축의 길이는 일정하다.
            // 그렇기 때문에, 왼쪽/오른쪽 중 더 작은 y축이 높이가 되므로
            // 작은 값을 가진 쪽이 움직이는게 맞다.

        int li=0, ri=height.length-1;
        int width=0;
        while (li < ri) {

            int cur = (ri-li)*(Math.min(height[li], height[ri]));
            width = Math.max(cur, width);

            if(height[li] < height[ri]) {
                li++;
            } else {
                ri--;
            }
        }

        return width;
    }
}
```