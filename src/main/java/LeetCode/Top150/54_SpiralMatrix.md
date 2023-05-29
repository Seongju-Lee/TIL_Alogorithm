[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
54. Spiral Matrix

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    // dir-> 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위쪽
    private void rec(int[][] matrix, List<Integer> list, int x, int y, boolean[][] visited, int dir) {

        int[] xi = {0, 1, 0, -1};
        int[] yi = {1, 0, -1, 0};

        visited[x][y] = true;
        list.add(matrix[x][y]);

        int cnt = 4;
        while (cnt != 0) {

            int nx = x + xi[dir%4];
            int ny = y + yi[dir%4];

            if(nx>=0 && ny>=0 && nx<matrix.length && ny<matrix[0].length && !visited[nx][ny]) {
                
                rec(matrix, list, nx, ny, visited, dir);
                break;
            }


            dir++; // 다음방향
            cnt--;
        }
        

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        

        // 우, 하, 좌, 상 순으로 탐색
        // (범위 밖 or 이미 방문 했던 곳)이면 다음 방향을 탐색

        // 재귀로 진행 -> 재귀 들어갔다 나오면 바로 종료 되게끔(e.g. 오른쪽 다음 하,좌,상 갈 필요가 없음.)

        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        rec(matrix, list, 0, 0, visited, 0);

        return list;
        
    }
}
```