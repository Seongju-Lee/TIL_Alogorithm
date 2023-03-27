[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
695. Max Area of Island
## Approach
<!-- Describe your approach to solving the problem. -->

#### dfs 풀이
- [0, 0]부터 [m, n]까지 반복.
- dfs 진행하면서, count++진행.
- dfs 종료 시, count와 answer 비교 통해 answer에 최댓값 누적.

## Complexity
- Time complexity: O(n^3)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    static int count;
    int[][] dfs(int[][] grid, int x, int y, int m, int n) {

        count++;
        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};
        
        for(int i=0; i<4; i++) {

            int nx = x+xi[i];
            int ny = y+yi[i];

            if(nx >=0 && ny >= 0 && nx<m && ny<n && grid[nx][ny]==1) {
                grid[nx][ny] = -1;
                grid = dfs(grid, nx, ny, m, n);
            }
        }

        return grid;
    }

    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int answer=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == 1) {
                    grid[i][j] = -1;
                    grid = dfs(grid, i, j, m, n);
                    answer = Math.max(answer, count);
                    count = 0;
                }
            }
        }

        return answer;
    }
}
```