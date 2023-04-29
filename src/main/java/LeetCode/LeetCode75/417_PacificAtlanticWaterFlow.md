[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
417. Pacific Atlantic Water Flow

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity


- Time complexity(BFS): O(n^3)
  주어진 heights의 모든 원소를 하나하나 탐색 - O(n^2)  
  원소 하나를 탐색하는 Q가 비어질 때까지 n번 탐색하므로, O(n^3)의 시간복잡도를 가진다.

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public boolean bfs(Queue<int[]> q, int xPoint, int yPoint, int[][] heights, int m, int n, boolean[][] visited) {

        boolean pFlag = false, aFlag = false;
        q.offer(new int[]{xPoint, yPoint}); // 탐색할 좌표 삽입
        visited[xPoint][yPoint] = true;

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            
            int size = q.size();
            for (int s=0; s<size; s++) {


                int[] point = q.poll();
                
                int x = point[0];
                int y = point[1];

                for(int i=0; i<4; i++) { // 네 방향 탐색.

                    int nx = x+xi[i];
                    int ny = y+yi[i];

                    if(nx>=0 && ny>=0 && nx<m && ny<n && !visited[nx][ny] && heights[nx][ny]<=heights[x][y]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});

                        
                    }

                    if(nx<0 || ny<0) pFlag=true;
                    if(nx==m || ny==n) aFlag = true;

                }
                
            }


            // 태평양, 대서양에 모두 흐를 수 있으면 true 바로 리턴.
            if(aFlag&&pFlag) return true;
        }

        
        return false;
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;

        // 한 셀마다 bfs 적용.
        // pflag, aflag를 두어서,
        // (행이 0 또는 열이 0)에 도달 가능하면 pFlag=true;
        // (행이 m 또는 열이 n)에 도달 가능하면 aFlag=true;
        // 한 군데 도달했다고 break X => 그 경로 통해 다른 해양으로 흐를 가능성 있음.
        // q size만큼 반복 종료될 때마다, aFlag&&pFlag 상태 확인하는 쪽으로 진행.
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {

                Queue<int[]> q = new LinkedList<>();
                if(bfs(q, i, j, heights, m, n, new boolean[m][n])) {
                    list.add(Arrays.asList(i, j));
                }

            }
        }

        return list;

    }
}
```