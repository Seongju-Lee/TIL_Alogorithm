[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
79. Word Search
## Approach
<!-- Describe your approach to solving the problem. -->
dfs 탐색 풀이

## Complexity
- Time complexity: O(2^n)  

<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    static boolean flag;

    // idx: 현재 word의 인덱스
    void dfs(char[][] board, String word, int x, int y, int idx, boolean[][] visited, int m, int n) {


        if(idx == word.length()-1 && board[x][y] == word.charAt(idx) ) {
            flag = true;
        } else if(idx < word.length() ){

            int[] xi = {-1, 0, 1, 0};
            int[] yi = {0, 1, 0, -1};

            for(int i=0; i<4; i++) {
                int nx = x + xi[i];
                int ny = y + yi[i];

                if(nx>=0 && ny>=0 && nx<m && ny<n && board[nx][ny] == word.charAt(idx+1) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(board, word, nx, ny, idx+1, visited, m, n);
                    visited[nx][ny] = false;
                }
            }

        }

    }
    public boolean exist(char[][] board, String word) {
        
        int m = board.length; // 행의 개수
        int n = board[0].length; // 열의 개수

        flag = false;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    dfs(board, word, i, j, 0, visited, m, n);
                    if(flag) return flag;
                    visited[i][j] = false;
                }                
            }
        }

        return false;

    }
}
```