
# Intuition
[45. Jump Game II](https://leetcode.com/problems/jump-game-ii/description)

# Approach
세 가지로 해답을 정의 했음    
1. 최소한의 이동으로 가야 한다면, 결국 **현재 인덱스에서 갈 수 있을만큼 최대한** 가야한다.
2. 때문에, **현재 인덱스**에서 가장 멀리 갈 수 있는 위치값을 저장한다. (스냅샷 느낌)
3. for-loop을 돌며, 한 칸씩 이동하다가 2번에서 저장한 위치 값을 만나면 점프 카운트를 +1 한다.


# Complexity
- **Time complexity:**     
O(n) - 배열의 크기가 n일 때, n만큼 순회   

- **Space complexity:**    
O(1) - 값을 임시로 저장할 최소한의 변수만 선언하고, 사용 

# Code
```kotlin []
class Solution {
    fun jump(nums: IntArray): Int {
        var n = nums.size
        var max = 0
        var snapshot = 0 
        var count = 0

        // 마지막 전 값이 0이어도, 알 바 아님 -> 어차피 문제 전제가 도착 가능임
        for (i in 0..(n-2)) {
            max = maxOf(max, nums[i]+i) // 현재 위치에서 가장 멀리 갈 수 있는 위치

            if (i == snapshot) {
                snapshot = max
                count++
            }
        }
        
        return count
    }
}
```
