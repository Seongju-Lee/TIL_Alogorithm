[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
947. Most Stones Removed with Same Row or Column

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^2)  
이중 for문: O(n^2)  
DFS: O(n+v) v: 간선개수
- Time complexity: O(n)  
Union-Find

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public void dfs(List<Integer>[] list, int depth, boolean[] visited, int idx) {


        visited[idx] = true;
        for(int j : list[idx]) {

            if(!visited[j]) {
                dfs(list, depth+1, visited, j);
            }
        }
        
    }

    public int removeStones(int[][] stones) {
        
        // index를 이용해서, dfs 풀이
        int n = stones.length;
        if(n == 1) {
            return 0;
        }


        List<Integer>[] list = new ArrayList[n];   

        // 인접 리스트 생성     
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
            int[] stone = stones[i];
            for(int j=0; j<n; j++) {

                if(i == j) continue;

                if(stone[0] == stones[j][0] || stone[1] == stones[j][1]) {
                    list[i].add(j); // 현재돌(stone) 리스트에 같은 라인의 돌(stones[j]) 추가
                }
            }
        }

        // dfs를 이용하여 최대 깊이를 찾는다. (누적)
        boolean[] visited = new boolean[n];
        int a=0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(list, 0, visited, i);
                a++;
            }
        }

        return n-a;
    }
}
```