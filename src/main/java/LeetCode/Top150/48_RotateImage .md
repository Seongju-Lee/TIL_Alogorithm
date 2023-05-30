[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
48. Rotate Image

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^2)  

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        for(int i=0; i<(n/2); i++) { // 행
            for(int j=i; j<(n-i-1); j++) { // 열
                
                // [i][j] 값을 rotate로 switch 한다.
                // 현재 위치인 [i][j]를 [j][(n-1)-i]로 이동 시키면 된다.


                int tmp = matrix[i][j];

                matrix[i][j] = matrix[(n-1)-j][i]; // 이동 1
                matrix[(n-1)-j][i] = matrix[(n-1)-i][(n-1)-j]; // 이동 2
                matrix[(n-1)-i][(n-1)-j] = matrix[(n-1)-((n-1)-j)][(n-1)-i]; // 이동 3
                
                matrix[(n-1)-((n-1)-j)][(n-1)-i] = tmp;

            }
        }

        
    }
}
```