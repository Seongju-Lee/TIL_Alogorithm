[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
1091. Shortest Path in Binary Matrix
## Approach
<!-- Describe your approach to solving the problem. -->
BFS를 이용한 최단거리 풀이.  
주의할점.  
초기 접근 시, 방문 좌표를 체크하는 지점이 일부 좌표가 Q에 중복되어 들어가게끔 함.  
Q에 삽입과 동시에 다음 방문좌표를 체크해주는 방향으로 최적화.
## Complexity
- Time complexity: O(n^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    int bfs(int[][] grid, int n) {

        Queue<int[]> q = new LinkedList<>(); // q 생성
        q.offer(new int[]{0,0}); // 시작점 삽입
        
        int[] xi = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] yi = {0, 1, 1, 1, 0, -1, -1, -1};
        int dis = 1;

        while (!q.isEmpty()) {

            int size = q.size();
            for(int i=0; i<size; i++) { // 같은 거리내에 갈 수 있는 다음위치 q에 삽입위한 반복문.

                int[] point = q.poll();
                
                if(point[0] == (n-1) && point[1] == (n-1)) return dis;

                // grid[point[0]][point[1]] = 1; // 이미 경유한 지점은 1로 표시. => 여기서 하면 이미 중복 좌표가 너무많음 TLE
                for(int j=0; j<8; j++) { // 현재 위치에서 인접한 8방향 탐색(같은 거리.)

                    int nx = point[0] + xi[j]; // 8방향 탐색 x좌표
                    int ny = point[1] + yi[j]; // 8방향 탐색 y좌표

                    if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1; // 여기서 변경해준다.
                        q.offer(new int[]{nx, ny});
                    }
                }

            }
            dis++;
        }

        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1) return -1;

        return bfs(grid, grid.length);
    }
}
```