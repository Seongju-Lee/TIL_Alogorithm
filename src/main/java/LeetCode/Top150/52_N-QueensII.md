[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
52. N-Queens II

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n! == n^n)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    // num: 말 번호
    void dfs(int n, int[] ans, int num, boolean[][] visited, int x, int[] xi, int[] yi) {

        if(num == n) {
            ans[0]++;
            return;
        }

        for (int i=x; i<n; i++) {
            for (int j=0; j<n; j++) {
                
                if(visited[i][j]) continue;

                boolean flag = true;
                for (int s=0; s<8; s++) {

                    // 8방향 체스판 끝까지 탐색
                    int nx = i;
                    int ny = j;
                    
                    do{
                        nx = nx + xi[s];
                        ny = ny + yi[s];
                    } while (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]);

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny]) {
                        flag = false;
                        break;
                    }
                }

                if(!visited[i][j] && flag) {
                    visited[i][j] = true;
                    dfs(n, ans, num+1, visited, i, xi, yi);
                    visited[i][j] = false;
                }
                
            }
        }

    }
    
    public int totalNQueens(int n) {
        
        // 첫번째 말이 (n-1, n-1)에 다를 때까지비교 진행.
        int[] ans = new int[1];
        boolean[][] visited = new boolean[n][n];
        int[] xi = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] yi = {0, 1, 1, 1, 0, -1, -1, -1};
        dfs(n, ans, 0, visited, 0, xi, yi);
        return ans[0];
    }
}
```