[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
73. Set Matrix Zeroes

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

    public void setZeroes(int[][] matrix) {

        
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {

                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }

            }
        }

        // col 0 지정
        for (int col : cols) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        // row 0 지정
        for (int row : rows) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }

    }
}
```