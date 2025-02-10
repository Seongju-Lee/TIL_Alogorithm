# Intuition
[55. Jump Game](https://leetcode.com/problems/jump-game/description)

# Approach
0번 인덱스부터 시작하여 맨 끝에 인덱스에 도달 가능한지 확인하는 문제    

그리고, **각 요소는 오른쪽으로 이동할 수 있는 최대 크기**다.   
즉, 요소의 값이 크면 클수록 배열의 끝에 도달할 수 있는 가능성이 높아지는 것    

따라서 배열의 크기가 n이라고 할 때, 0..(n-1)을 순서대로 경유하며, 현재 위치한 인덱스에서 최대 이동 가능한 값을 구해나가면 된다. 

1. **현재 위치의 값**과 **현재까지의 최대 이동 가능횟수**를 비교해서 값을 업데이트하며 나아가면된다.

# Complexity
- **Time complexity:**    
O(n): 배열의 크기만큼 각 요소를 한번씩 경유함

- **Space complexity:**    
O(1): 추가적인 메모리 공간은 최댓값을 저장하기 위한 변수만을 선언해서 사용함

# Code
```kotlin []
class Solution {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size
        var maxCount = 0

        for (i in nums.indices) {
            maxCount = maxOf(maxCount-1, nums[i])
            if (maxCount <= 0 && i < (n-1)) {
                return false
            }
        }   
        return true
    }
}
```
