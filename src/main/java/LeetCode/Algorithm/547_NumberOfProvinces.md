[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
547. Number of Provinces
## Approach
<!-- Describe your approach to solving the problem. -->
Union-Find를 이용한 풀이.

## Complexity
- Time complexity: O(n^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    static int[] conn;
    public void union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if(findA != findB) conn[findA] = findB;

    }

    public int find(int a) {

        if(a == conn[a]) return conn[a];
        else return conn[a] = find(conn[a]);
    }
    
    public int findCircleNum(int[][] board) {

        // union-find 풀이.
        // 0~(n-1)까지 모든 행, union 진행.
        int n = board.length;

        conn = new int[n];
        for(int i=0; i<n; i++) {
            conn[i] = i;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1)
                    union(i, j);
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            set.add(find(i));
        }

        return set.size();
    }
}
```