[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
994. Rotting Oranges
## Approach
<!-- Describe your approach to solving the problem. -->
BFS를 이용하되, 두 가지 예외만 처리하면 된다.
<br> 예외처리 내용
<br> - 오렌지가 없는 경우.
<br> - 오렌지가 모두 썩을 수 없는 경우
## Complexity
- Time complexity: O(n^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int orangesRotting(int[][] grid) {
        
        // 처음에 확인할 때, 1의 개수 확인. -> fresh
        // 2의 위치를 찾아서 Q에 삽입, minute=-1;
        int fresh=0, minute=-1; // fresh: 신선한 오렌지 개수, minute: 다 썩는데 걸리는 시간.
        Queue<int[]> q = new LinkedList<>(); // 동일한 시간(minute)마다 썩는 오렌지의 좌표들 ([x좌표, y좌표])

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) fresh++; // 신선한 오렌지 개수 카운트.
                else if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j}); // 애초에 썩은 오렌지 저장.
                }
            }
        }

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};
        int count=0; // fresh -> adjacent으로 변하는 횟수.

        if(q.isEmpty() && fresh==0) return 0;

        while (!q.isEmpty()) { // 썩은 오렌지의 좌표가 없으면 종료.

            int size = q.size(); // 현재 동일한 시간에 썩는 오렌지의 개수
            minute++; // 썩은 오렌지가 있으면 시간 증가.

            for(int i=0; i<size; i++) {

                int[] point = q.poll();
                for(int j=0; j<4; j++) { // 인접한 네 방향 탐색.

                    int nx = point[0] + xi[j];
                    int ny = point[1] + yi[j];

                    if(nx >=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]==1) {
                        count++; // fresh -> adjacent으로 변하는 횟수가 1 증가
                        grid[nx][ny] = 2; // 썩은 오렌지로 변경.
                        q.offer(new int[]{nx, ny}); // 다음 썩은 오렌지를 찾기 위해 큐에 변경된 오렌지 삽입.

                    }
                }
            }


        }

        if(count != fresh) return -1;
        else return minute;
        // 끝나고, count != fresh => return -1
                  // else => return minute;


    }
}
```