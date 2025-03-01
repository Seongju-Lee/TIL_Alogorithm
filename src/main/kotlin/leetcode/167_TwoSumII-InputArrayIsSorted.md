# Intuition
[167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description)

# Approach
**1. 초기 접근 방식(슬라이딩 윈도우)** - Time taken: 18m    
li를 더 작은 인덱스, ri을 더 큰 인덱스로 정의하고 아래와 같이 수행   
- 인덱스가 작은것끼리 더할수록 더 작은 값인게 사실
- li의 값과 ri의 값을 sum이라고 둠
- sum이 target보다 클때까지는 ri만 이동
- sum이 target보다 작아지는 순간부터는 li만 이동하면서 같아지는 값은 찾음

위 방식에는 큰 오류가 있음 -> 배열의 중간에 있는 값끼리의 합이 target인 경우 찾을 수 없음
+) 슬라이딩 윈도우 방식대로 ri와 li를 조건을 주어가며 이동한다고 하더라도 구현이 너무 복잡해짐   


**2. 최종(투 포인터)** - Time taken: 2m   
결국 인덱스가 작은 것끼리 더할수록 값이 더 작은 값인게 사실인건 변함없다.  
때문에 ri를 마지막 인덱스, li를 0번 인덱스로 최초 정의해놓고 아래와 같이 수행    
- sum이 target보다 작으면 li++
- sum이 target보다 크면 ri--

Total time taken - 20m    
처음에 "인덱스가 작은 것끼리 더할수록"에 매몰되어 크게 로직을 놓침 -> 핵심은 "두 값을 더하는 모든 경우의 수를 최대한 효율적으로" 

# Complexity
- **Time complexity:**    
O(n): numbers의 크기가 n일 때, li와 ri가 배열의 양 끝에서 시작하여 중앙을 향해 이동하므로  최악의 경우에도 총 O(n)번의 연산이 필요하다.

- **Space complexity:**     
O(1): 인덱싱을 위한 두 변수와 정답을 저장할 변수 등 상수 개의 메모리 공간만 추가로 할당

# Code
```kotlin []
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val n = numbers.size

        var li = 0
        var ri = n-1
        var sum = numbers[li] + numbers[ri]
        while (li < ri) {
            if (sum == target) return intArrayOf(li+1, ri+1)
            else if (sum < target) li++
            else ri--

            sum = numbers[li] + numbers[ri]
        }

        return intArrayOf(li+1, ri+1)
    }
}
```
