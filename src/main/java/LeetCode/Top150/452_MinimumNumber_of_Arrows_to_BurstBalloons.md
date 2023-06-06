[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
452. Minimum Number of Arrows to Burst Balloons

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
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (arr1, arr2) -> {
            return arr1[1] - arr2[1];
        });

        int n = points.length;
        int arrowCnt = 0;

        int i=0;
        while (i < n) {

            int x = points[i][1]; // 가장 빨리 끝나는 녀석
            while ( (i<n) && (points[i][0] <= x && x <= points[i][1])) {
                i++;
            }

            arrowCnt++;
        }



        return arrowCnt;
    }
}
```