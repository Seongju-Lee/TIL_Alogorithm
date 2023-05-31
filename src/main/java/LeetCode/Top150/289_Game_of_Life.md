[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
289. Game of Life

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
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        boolean[][] changeCell = new boolean[m][n];

        int[] xi = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] yi = {0, 1, 1, 1, 0, -1, -1, -1};


        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                
                // 기본적으로 현재 셀의 마주한 8군데 탐색
                int cnt = 0; // 8군데 중, 1이 몇 개인지 탐색
                for (int s=0; s<8; s++) {

                    int nx = i + xi[s];
                    int ny = j + yi[s];

                    if(nx >= 0 && ny >= 0 && nx < m && ny < n && board[nx][ny] == 1) {
                        cnt++;
                        if(cnt > 3) break; 
                    }
                }

                // 셀이 1일 때,
                // 8군데 중 1이 두 개 미만이면, 0으로 변경
                // 8군데 중 1이 세 개 초과면, 0으로 변경
                if(board[i][j] == 1 && (cnt < 2 || cnt > 3)) {
                    changeCell[i][j] = true;                    
                }
                
                // 셀이 0일 때,
                // 8군데 중 1이 세 개이면, 1로 변경
                else if(board[i][j] == 0 && cnt == 3) {
                    changeCell[i][j] = true;
                }
            }
        }

        
        // 위 방식대로 changeCell[][]의 값이 true면 그 위치의 값 변경
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {

                if(changeCell[i][j]) {
                    board[i][j] = (board[i][j] == 1 ? 0 : 1);
                }

            }
        }
        

    }
}
```