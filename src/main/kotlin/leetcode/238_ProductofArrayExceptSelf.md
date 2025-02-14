# Intuition
[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description)

# Approach
현재 인덱스에 위치한 값을 제외한, 배열의 모든 곱을 구하는 문제   

즉, 배열의 모든 곱을 구한 후에 현재 값을 나누면 됨
하지만, 이 접근은 0이 포함되어 있으면 많이 복잡해짐         

- 배열1: 첫번째 인덱스부터 마지막 인덱스까지 누적 곱 값을 인덱스 차례대로 저장
- 배열2: 마지막에서 첫번째까지 누적 곱 값을 인덱스 역순으로 저장  

이 상태에서, 각 인덱스의 배열 1의 직전값과 배열 2의 직후값을 곱하면 현재 인덱스의 값만 빼고 모든 값을 곱한 처리가 될 것이다.    
즉, (현재 값을 기준으로 왼쪽에 있는 모든 요소들의 곱 x 오른쪽에 있는 모든 요소들의 곱) 이 결과인 것이다.


# Complexity
**- Time complexity:**     
O(n): 배열의 길이가 n일 때, 순차 탐색을 2번 진행하므로 n 시간복잡도를 가짐   

**- Space complexity:**     
O(n): 배열의 누적곱을 저장하기 위한 추가적인 메모리 공간을 n 크기만큼 선언하고 사용함    

# Code
```kotlin []
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n)

        val left = IntArray(n)
        val right = IntArray(n)
        left[0] = nums[0]
        right[n-1] = nums[n-1]

        for (i in 1..(n-1)) {
            left[i] = left[i-1] * nums[i]
            right[n - 1 - i] = right[n - i] * nums[n - 1 - i]
        }

        for (i in 0..(n-1)) {
            when {
                (i==0) -> ans[i] = right[1]
                (i == (n-1)) -> ans[i] = left[n-2]
                else -> ans[i] = right[i+1] * left[i-1]
            }
        }
        return ans
    }
}
