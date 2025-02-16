# Intuition
[135. Candy](https://leetcode.com/problems/candy/description)

# Approach
처음엔 count에만 신경쓰려고 함   
예를 들어 마킹용 dp배열을 하나 두고, 좌우측 값을 비교하면서 특정 인덱스까지 필요한 최소한의 사탕 갯수를 저장하려고 함  

하지만 경우에 따라 인덱스의 값이 변경되면 이전 인덱스들의 값을 전부 업데이트해야 하는 경우도 발생함 -> 결국 O(n^2)

**해결**

O(n)의 시간복잡도로 해결하기 위해, **인접한 인덱스**에 접근하는 방법을 **왼쪽 -> 오른쪽 방향**과 **오른쪽 -> 왼쪽 방향** 두 가지로 나눔   

1. 왼쪽 -> 오른쪽으로 이동: 왼쪽에 인접한 값만 비교
2. 오른쪽 -> 왼쪽으로 이동: 오른쪽에 인접한 값만 비교

1번과 2번은 각각 단방향으로 흘렀을 때, 현재 인덱스에서 가질 수 있는 최소 사탕 갯수를 저장하고 있다.   
최종적으로 **1번과 2번 중 특정 인덱스의 최댓값**이 올 수 있는 최소 사탕 갯수인 셈이다.   


# Complexity
- **Time complexity:**.   
O(n): 배열의 크기가 n이라고 할 때, 3*n만큼의 시간복잡도를 가짐  

- **Space complexity:**.    
O(n): 단방향을 기준으로 최솟값을 저장하기 위해 n크기의 배열 두 개를 메모리 공간에 할당    

# Code
```kotlin []
class Solution {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        var total = 0

        val left = IntArray(n)
        val right = IntArray(n)

        // 1. 왼 -> 오
        left[0] = 1
        for (i in 1..(n-1)) {
            left[i] = if (ratings[i] > ratings[i-1]) left[i-1]+1 else 1
        }

        // 2. 오 -> 왼
        right[n-1] = 1
        for (i in (n-2) downTo 0) {
            right[i] = if (ratings[i] > ratings[i+1]) right[i+1]+1 else 1
        }

        for (i in 0..(n-1)) {
            total += maxOf(left[i], right[i])
        }
        return total
    }
}
```
