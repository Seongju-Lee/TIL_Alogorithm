# Approach
이미 서로 다른 두 배열이 각각 **non-decreasing order**인 상태였으며, 각 원소의 크기만 비교해가며 "**non-decreasing order**"으로 값을 정렬하면 되는 문제  

값을 **오름차순으로 정렬한다는 사고 방식에서 -> 뒤에서부터 내림차순 정렬 한다는 사고로 전환**하는게 키

# Complexity
- Time complexity:
**O(n+m)** num1의 원소의 갯수만큼 반복하며 작업을 수행

- Space complexity:
**O(n)** 추가적인 메모리 공간을 사용하지 않고, 주어진 nums1 배열을 수정해가며 작업을 수행

# Code
```kotlin []
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
       var i1 = m-1
       var i2 = n-1

       for (currentIndex in nums1.lastIndex downTo 0) {
            nums1[currentIndex] = when {
                i1 < 0 ->  nums2[i2--]
                i2 < 0 -> nums1[i1--]
                nums2[i2] > nums1[i1] -> nums2[i2--]
                else -> nums1[i1--]
            }
       }
    }
}
```
