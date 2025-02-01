# Intuition
[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)

# Approach
문제를 정리하면, 첫번째 자리부터 중복되지 않는 개수만큼 in-place 방식으로 값을 변경을 요구하는 것이라 판단 함.  
때문에, `li`와 `ri`라는 두 개의 인덱스를 1로 시작(0번 인덱스의 값은 무조건 고정)하여 값을 판단
   

- `li`: 중복되지 않은 최초의 값 인덱스
- `ri`: 다음으로 중복되지 않는 최초의 값 인덱스

# Complexity
- Time complexity:
O(n): nums의 길이가 n이라고 할 때, 인덱스 1부터 (n-1)까지 ri가 이동하면서 값을 비교하는 형식으로 구현했으므로 O(n) 시간복잡도를 가짐

- Space complexity:
O(1): in-place 방식으로, nums 배열 이외에 다른 메모리 할당 변수들이 동적으로 되지 않는다. 따라서 li, ri 등 변수만 할당할 공간이 필요하므로 O(1) 공간복잡도를 가짐

# Code
```kotlin []
class Solution {
    fun removeDuplicates(nums: IntArray): Int {

    var li = 1
    var ri = 1
    var currentValue = nums[li]
    val len = nums.size

    while (ri < len) {
        if (nums[ri] != currentValue) {
            nums[li] = nums[ri]
            currentValue = nums[li]
            li++
        }
        ri++
    }
    return li
}
}
```
