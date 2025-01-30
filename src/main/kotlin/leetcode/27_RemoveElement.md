# Approach
- in-place 방식으로 앞에서부터 k개 만큼의 원소를 기준으로 값을 판단하고 있음

위 맥락에서 봤을 때, 두 가지 접근법을 떠올릴 수 있었음
1. `li`, `ri`를 0으로 고정 시켜놓고, 값을 비교해가며 li와 ri를 각각 이동 시킴(ri가 끝까지 도달할 때까지)
2. `li`를 첫번째 인덱스로, `ri`를 마지막 인덱스로 초기화 해놓고, 투 포인터 방식으로 값을 변경해가는 방식

1번 방식의 경우 ri에 위치한 값을 `val` 값으로 마킹하는 등 좀 더 복잡하게 생각해야 하며, 무엇보다 시간 복잡도가 무조건 `nums`의 길이만큼이므로 O(n)이 됨
2번 방식은 비교적 간단한 구조이며, 시간 복잡도 또한 모두 지워야 하는 경우를 제외하면 1번보다는 짧은 런타임을 가질 수 있음

# Complexity
- Time complexity:
O(n): 투 포인터를 통해 진행한다고 가정할 때, 모든 원소를 제거해야 하는 경우에 모든 원소를 탐색해야 하는 경우 O(n)이라는 시간 복잡도가 발생 함

- Space complexity:
O(1): in-place 방식으로 값을 변경하고 있고, ´li´, ´ri´ 외 추가적인 공간을 사용하지 않으므로 상수 만큼의 공간을 차지함

# Code
```kotlin []
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var li = 0
        var ri = nums.size-1

        while (li <= ri) {
            when {
                (nums[li] == `val`) -> {
                    if (nums[ri] != `val`) {
                        nums[li++] = nums[ri]
                    }
                    ri--
                }
                else -> li++
            }
        }
        return li
    }
}
```
