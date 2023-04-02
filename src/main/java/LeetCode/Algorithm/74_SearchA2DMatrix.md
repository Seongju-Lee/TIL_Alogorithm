[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
74. Search a 2D Matrix
## Approach
<!-- Describe your approach to solving the problem. -->
행: n, 열: m  
각 행의 끝 부분과 target을 비교해 나아가면서, target이 위치할 수 있는 행을 찾은 후 -> 그 열에서 target을 찾음.  
위와 같은 방식도 생각할 수 있으나 이 방식의 시간복잡도는 O(n+m) 또는 O(n+logM)이었을 것이다.  
  
O(log(MN))으로 구현하고 싶었기에 행에 대한 이분탐색 -> 그 행에서의 target을 찾기 위한 이분탐색  
위 처럼 두번의 이분탐색을 진행하였다.

## Complexity
- Time complexity: O(log(MN))
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // 각 행마다 첫번째 값: li, 마지막 값: ri
        int row = matrix.length; // 2차원 배열의 행 길이
        int col = matrix[0].length; // 2차원 배열의 열 길이.

        int li = 0, ri=(row-1); // li: 첫번째 행, ri: 마지막 행


        // 각 행의 첫번째 값들을 이분탐색 하여 target이 있을 수 있는 행을 찾는다.
        while (li <= ri) {
            
            int mid = (li+ri)/2;

            if(matrix[mid][0] <= target) { // target이 mid행의 첫번째 값보다 크거나 같다면
                li = mid+1; // 최솟값을 가지는 행을 mid 다음 행으로 올린다. 
            } else {
                ri = mid-1;
            }
            
        }

        int curRow = (li-1); // target이 있을 수 있는 행.
        
        // System.out.println(curRow);

        li = 0; // curRow행의 첫번째 원소.
        ri = (col-1); // curRow행의 마지막 원소.
        
        while (li <=ri && curRow >= 0) {

            int mid = (li+ri)/2;

            if(matrix[curRow][mid] == target) return true;

            if(matrix[curRow][mid] < target) {
                li = mid+1;
            } else {
                ri = mid-1;
            }

        }

        return false;
    }
}
```