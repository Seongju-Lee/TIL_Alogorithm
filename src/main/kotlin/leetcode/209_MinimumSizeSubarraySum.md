# Problem
[209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description)

# Approach
문제 요구조건이 subArray이기 때문에 결국 인접해야 한다.  
즉, 인접한 원소들 중, 조건을 만족하는 최소 길이를 찾아라 -> 슬라이딩 윈도우가 직관적으로 떠오른다.    

기준이 되어 이동하는 인덱스를 `ri`라 하고, 조건을 만족했을 때 최소 길이를 찾기 위해 이동하는 인덱스를 `li`라고 하자.   
 
1. ri 이동하면서 조건을 만족할 경우를 찾는다.
2. 조건을 만족하는 경우(li ~ ri까지의 누적합이 target보다 크거나 같은 경우) li를 이동하면서 li ~ ri의 최소 길이를 찾는다.

    2-1. 마지막 ri 값에 의해 조건이 만족된 것인데, ri 값이 워낙 커서 앞서 나온 인덱스들의 값이 필요 없을 수 있으므로.

# Complexity
- **Time complexity:**   
O(n): 주어진 배열의 길이를 n이라고 할 때, 마지막 인덱스 하나로 조건을 만족해버리면 최대 2*n만큼 loop를 수행함
  -  `ri`가 이동하는데 드는 비용 - O(n)
  -  `li`가 이동하는데 드는 비용 - O(n)

- **Space complexity:**
O(1): 값을 임시로 저장할 상수 개의 메모리 공간만을 추가적으로 사용함

# Code
```kotlin []
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var ans = nums.size + 1
        var sum = 0

        var li = 0
        var ri = 0
        val n = nums.size

        while (ri < n) {
            
            sum += nums[ri]

            while (sum >= target) {
                ans = minOf(ans, (ri-li)+1)
                sum -= nums[li]
                li++
            }
            ri++
        }

        return if (ans == (n+1)) 0 else ans
    }
}
```
