[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
200. Number of Islands
## Approach
<!-- Describe your approach to solving the problem. -->
BFS를 이용한 풀이.

## Complexity
- Time complexity: O(n^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    static int[] xi = {-1, 0, 1, 0};
    static int[] yi = {0, 1, 0, -1};

    public char[][] dfs(char[][] grid, int x, int y, int m, int n) {

        grid[x][y] = '0';
        for(int i=0; i<4; i++) {

            int nx = x + xi[i];
            int ny = y + yi[i];

            if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny] == '1') {
                grid = dfs(grid, nx, ny, m, n);
            } 
        }
        
        
        return grid;
    }

    public int numIslands(char[][] grid) {
        

        int m = grid.length;
        int n = grid[0].length;
        int ans=0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == '1') {
                    grid = dfs(grid, i, j, m, n); // 경유한 지점을 1->0으로 변경해놓은 grid를 리턴.
                    ans++; // 1이 한번 나온 것은 하나의 새로운 섬을 발견했다는 의미로, 섬의 카운트를 +1한다.
                }
            }
        }

        return ans;

    }
}
```