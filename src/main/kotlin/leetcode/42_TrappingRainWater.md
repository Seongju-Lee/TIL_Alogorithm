# Intuition
[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water)

# Approach
본질은 특정 위치를 기준으로 하여  왼쪽의 가장 큰 기둥과 오른쪽의 가장 큰 기둥이 있다면, 두 기둥 중 **최대** 더 작은 기둥의 크기만큼 그 가운데 공간들에 물을 부을 수 있는 것이다.     

여기서, 최대라고 한 이유는 그 가운데 짜잘한 기둥들이 있으면 그 차이만큼만 차기 때문이다.   

하지만, 위와 같이 특정 위치를 기준으로 하여 왼쪽/오른쪽 기둥을 모두 스캔해가며 구현하는 것은 O(n^2) 시간복잡도를 가질뿐더러 구현도 매우 복잡해진다.    

때문에 단방향으로 최대 담을 수 있는 물의 양을 확인할 수 있다.    
1. 왼쪽에서 오른쪽 방향으로 이동하며, 가장 큰 기둥의 값을 기준으로 계속 물을 부으면서 이동한다.
2. 오른쪽에서 왼쪽 방향으로 이동하며, 가장 큰 기둥의 값을 기준으로 계속 물을 부으면서 이동한다.

즉, 1번에서 가장 큰 기둥은 (특정 위치를 기준으로) 왼쪽 가장 큰 기둥인 셈이고 2번에서 가장 큰 기둥은 오른쪽에서 가장 큰 기둥인 셈이다.     

1번과 2번을 통해 각 인덱스에 채운 물의 경우의 수가 2가지 있고, 이 중에 더 작은 값이 그 인덱스에 최대로 부을 수 있는 물의 양이 된다.   

# Complexity
- **Time complexity:**    
O(n): 배열의 길이가 n일 때, 단방향으로 두 번 순회

- **Space complexity:**     
O(n): 배열의 길이가 n일 때, 단방향으로의 각 배열을 두 개 선언(가독성을 위해 별도로 나눔)

# Code
```kotlin []
class Solution {
    fun trap(height: IntArray): Int {
        val n = height.size
        
        var currentMax = 0
        // 왼 -> 오: 현재까지의 최대보다 큰게 나오면 초기화
        val left = IntArray(n)
        for (i in (0..(n-1))) {
            if (height[i] <= currentMax) {
                left[i] = currentMax - height[i]
            } else {
                currentMax = height[i]
            }
        }

        // 오 -> 왼: 현재까지의 최대보다 큰게 나오면 초기화
        val right = IntArray(n)
        var result = 0
        currentMax = 0
        for (i in (n-1) downTo 0) {
            if (height[i] <= currentMax) {
                right[i] = currentMax - height[i]
            } else {
                currentMax = height[i]
            }
            result += minOf(left[i], right[i])
        }
        return result
    }
}
```
