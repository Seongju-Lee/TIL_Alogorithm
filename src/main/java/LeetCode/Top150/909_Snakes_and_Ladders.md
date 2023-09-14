[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
909. Snakes and Ladders


## Approach
-  BFS를 사용하여 가장 마지막 칸에 도달하는 최소 이동 횟수를 계산
- 

<!-- Describe your approach to solving the problem. -->


## Complexity

- Time complexity: O(n^2)   
  - 1차원 배열로 변환하는 데 O(N^2) 시간이 소요
  - BFS를 사용하여 최소 이동 횟수를 계산하는 데도 O(N^2) 시간이 소요

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flattenedBoard = new int[n * n];
        boolean isEvenRow = true;
        int index = 0;

        // Flatten the board into a 1D array for easier traversal
        for (int i = n - 1; i >= 0; i--) {
            if (isEvenRow) {
                for (int j = 0; j < n; j++) {
                    flattenedBoard[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flattenedBoard[index++] = board[i][j];
                }
            }
            isEvenRow = !isEvenRow;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(1);
        visited.add(1);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentSquare = queue.poll();

                if (currentSquare == n * n) {
                    return moves;
                }

                for (int j = 1; j <= 6; j++) {
                    int nextSquare = currentSquare + j;

                    if (nextSquare <= n * n) {
                        int destination = flattenedBoard[nextSquare - 1];
                        if (flattenedBoard[nextSquare - 1] == -1) {
                            destination = nextSquare;
                        }

                        if (!visited.contains(destination)) {
                            queue.offer(destination);
                            visited.add(destination);
                        }
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}

```
