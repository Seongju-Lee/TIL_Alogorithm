[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
733. Flood Fill
## Approach
<!-- Describe your approach to solving the problem. -->
- DFS or BFS


## Complexity
- Time complexity: O(n^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int base = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc});

        int[] xi={-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        boolean[][] visited = new boolean[image.length][image[0].length];
        while (!q.isEmpty()) {

            int[] cur = q.poll();
            image[cur[0]][cur[1]] = color;
            visited[cur[0]][cur[1]] = true;
            for(int i=0; i<4; i++) {

                int nx = cur[0]+xi[i];
                int ny = cur[1]+yi[i];

                if(nx >= 0 && ny >=0 && nx<image.length && ny<image[0].length && !visited[nx][ny] && image[nx][ny] == base) {
                    q.offer(new int[]{nx, ny});
                }
                
            }

        }

        return image;
    }
}

```