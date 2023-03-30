[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
542. 01 Matrix
## Approach
<!-- Describe your approach to solving the problem. -->

<초기접근><br>
주어진 배열 mat에서 모든 인덱스를 순회하면서, 1인 값이 나오면 bfs를 이용하여 0을 찾도록 구현.
<br> 생각해보면, O(n^4)의 시간복잡도를 가지게 된다. (for문 안에, bfs가 구현 되어있음.)

<접근방식><br>
- 별도의 2차원 배열 answer에 0인 값을 q에 미리 삽입.
- bfs를 적용하여, q의 값 기준으로 4군데를 탐색하고 -> 0이 아닌 값이 있으면 +1을 하면서 q에 재삽입.
- 배열의 크기만큼만 bfs가 적용되므로 O(n^2)의 시간복잡도를 가지게 된다.

## Complexity
- Time complexity: O(n^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    int[][] bfs(int[][] answer, Queue<int[]> q, int x, int y, int m, int n) { 

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        while(!q.isEmpty()) { // O(n^2)

            int[] point = q.poll();

            for(int i=0; i<4; i++) { // O(1)

                int nx = point[0] + xi[i]; // 다음으로 탐색할 x좌표.
                int ny = point[1] + yi[i]; // 다음으로 탐색할 y좌표.
                
                if(nx>=0 && ny>=0 && nx<m && ny<n && answer[nx][ny] == -1) {
                    q.offer(new int[]{nx, ny});
                    answer[nx][ny] = answer[point[0]][point[1]]+1;
                }

            }

        }

        return answer;
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length; // m: 행의 개수.
        int n = mat[0].length; // n: 열의 개수

        int[][] answer = new int[m][n]; // answer: 특정 인덱스부터 0까지의 최소 거리를 저장할 배열.

        Queue<int[]> q = new LinkedList<>();

        // 행과 열에 대해 반복: O(n^2) == O(r*c)
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] != 0) {
                    answer[i][j] = -1; // mat에서 값이 0이 아닌 값은 -1로 변환
                } else {
                    q.offer(new int[]{i, j});
                }
            }
        }

        return bfs(answer, q, 0, 0, m, n);

    }
}
```