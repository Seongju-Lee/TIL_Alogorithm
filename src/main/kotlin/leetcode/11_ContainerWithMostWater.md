# Intuition
[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/description)

# Approach
최대 면적라는 것은 결국 **가로x세로 중에 가장 큰 값**    
즉, 모든 가로*세로의 경우의 수를 다 곱해보며 최댓값을 구해야 함   

우선 **가로**는 **처음~끝 범위가 가장 크면 됨**  
- 투포인터 적용해서, li를 처음, ri를 마지막 으로 설정함
   - 이러면 일단 가로를 가장 크게 setting한 셈임
- 세로를 가장 큰애 두 개 잡아서 가로랑 곱해야 함
   - 둘 중(왼쪽 세로, 오른쪽 세로)에 li가 작으면 li++, ri가 작으면 ri--
- 계속 최대 면적값 업데이트

# Complexity
- **Time complexity:**   
O(n): 주어진 배열의 크기가 n일 때, loop문을 수행하며 특정 매 반복마다 특정 조건에 따라 인덱스를 이동해가는 방식이므로 O(n)의 시간복잡도를 가짐 

- **Space complexity:**   
O(1): 반목문을 수행하면서 임시로 값을 저장할 변수를 상수 개 선언하고 사용하고 있음.  

# Code
```kotlin []
class Solution {
    fun maxArea(height: IntArray): Int {
        var li = 0
        var ri = height.size-1
        var maxArea = 0
        var leftHeight = 0
        var rightHeight = 0
        while (li < ri) {
            
            leftHeight = height[li]
            rightHeight = height[ri]
            maxArea = maxOf(maxArea, (ri-li)*minOf(leftHeight, rightHeight))
            if (leftHeight < rightHeight) li++
            else ri--
        }
        return maxArea
    }
}
```
