# Intuition
[80. Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/)

# Approach
중복된 원소가 연속으로 최대 2개 올 수 있을 때, 어떻게 처리할 것인가에 초점

- 기본적으로 two-pointers를 적용함
  - ri는 조건 상관없이 계속 이동
  - ri의 값이 이전 값과 동일하면 count++, 값이 달라지면 count를 1로 초기화
  - count 값에 따라 li 이동 여부를 결정  (2를 초과하면 이동 X, 미만이면 값 적용 후 이동)

# Complexity
- **Time complexity**    
O(n) - nums.size가 n일 때, n만큼 for-loop를 돌며 처리함

  참고    
  `until` 연산자에 비해 `..`가 40ms 가량 더 빠른 성능을 보임. `until` 연산 내부에서 `..`으로 변환하는 오버헤드의 차이로 보임

- **Space complexity**      
O(1) - 투 포인터 연산을 위한 `var` 프로퍼티를 제외한, 추가적인 배열 등을 사용하지 않음. in-place 방식으로 배열 내부의 값을 변경하는 형식의 풀이로, O(1) 공간의 메모리를 사용함   


# Code
```kotlin []
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
    var li = 0
    var count = 0
    var beforeValue = nums[li]
    val totalSize = nums.size

    for (ri in 0..(totalSize-1)) {
        if (nums[ri] == beforeValue) {
            if (count < 2) {
                beforeValue = nums[ri]
                nums[li++] = nums[ri]
            }
            count++
        } else {
            beforeValue = nums[ri]
            nums[li++] = nums[ri]
            count = 1
        }
    }

    return li;
}
}
```
