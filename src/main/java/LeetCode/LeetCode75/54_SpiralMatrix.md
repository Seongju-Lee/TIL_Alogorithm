[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
54. Spiral Matrix

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(N)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public void rec(int[][] matrix, boolean[][] visited, int x, int y, int m, int n,List<Integer> ans, int dis) {

        int[] xi = { 0, 1, 0, -1};
        int[] yi = { 1, 0, -1, 0};

        /**
        오른쪽 - 아래 - 왼쪽 - 위 순서대로 반복.
        0,1,2,3
         */
        while(ans.size() != m*n) {
            
            int nx = x + xi[dis];
            int ny = y + yi[dis];
            if(nx<0 || ny<0 || nx>=m || ny>=n || visited[nx][ny]) {

                if(dis == 3) dis = 0;
                else dis = (dis%3)+1;
                continue;
            }

            visited[nx][ny] = true;
            ans.add(matrix[nx][ny]);
            rec(matrix, visited, nx, ny, m, n, ans, dis);
            return;
        }
        
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length; 
        int n = matrix[0].length; 
        

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        ans.add(matrix[0][0]);
        
        int dis = 0; // 오른쪽 방향.
        rec(matrix, visited, 0, 0, m, n, ans, dis);
        
        return ans;
    }
}
```