[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
1706. Where Will the Ball Fall

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(N^2)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public int[] findBall(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        
        int[] ans = new int[n];

        // V존 탐색
        for(int i=0; i<m; i++) {
            for (int j=1; j<n; j++) {
                if(grid[i][j] == -1 && grid[i][j-1] == 1) {
                    grid[i][j] = 2;
                    grid[i][j-1] = 2;
                }
            }
        }

        for(int i=0; i<n; i++) {

            int row=0, col=i; // row: 현재 공의 행 위치, col: 현재 공의 열 위치
            boolean exit = true; // 공의 탈출 여부

            while (row != m) { // row(공)이 m(맨 아래)까지 도달하면 멈춤.

                if( row !=0 && (col < 0 || col >= n) ) { // 공이 경로를 벗어난 상태
                    exit = false;
                    break;
                }

                if(grid[row][col] == 2) { // V존에 공이 들어온 상태.
                    exit = false;
                    break;
                }

                if(grid[row][col] == 1) { // 1이면 오른쪽으로 이동.
                    col++;
                } else { // 그 외(-1) 이면 왼쪽으로 이동.
                    col--;
                }
                
                row++; // 무조건 행은 하단으로 이동.
            }


            if((col < 0 || col >= n)) exit = false; // 마지막 지점에서 나갔는 지, 못나갔는 지 최종확인

            if(exit)
                ans[i] = col; // 공의 최종 탈출 위치.
            else
                ans[i] = -1;
        }
        

        return ans;
    }
}
```