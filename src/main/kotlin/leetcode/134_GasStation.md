# Intuition
[134. Gas Station](https://leetcode.com/problems/gas-station)


# Approach
만약 (gas[i]-cost[i])+gas[i+1]을 반복적으로 계산하면서 한 바퀴를 돌 수 있는지 체크하는 방법이 있다.  
하지만, 이 방법은 O(n^2)을 가지고 있어, 해당 문제에서 주어지는 범위의 데이터 크기라면 적합하지 않다.   

결국, gas 배열의 모든 요소의 합 - cost 배열의 모든 요소의 합이 양수가 되어야만 한바퀴 돌 수 있다는 점에서 시작해야 함    
위 조건이 만족하지 않으면 무조건 -1을 반환하면 된다.  
때문에, 최소 인덱스를 반환할 방법만 고려하면 된다.  

1. gas-cost의 누적 합을 계산 - 이 결과가 음수가 나오는지 아닌지 확인하기 위함
2. gas-cost의 누적 합이 최초로 양수가 될 때, 인덱스를 저장 & 음수가 되기 전까지 계속 이 차이를 누적하여 저장한다.

2번에서 저장한 인덱스부터 한번도 음수로 안내려가고 배열 끝까지 접근하면 해당 인덱스가 정답인 것이다.  
여기서, 최초로 양수가 되는 지점을 저장하는게 쉽지 않기 때문에, 최초로 음수가 되는 시점에 i+1을 양수 인덱스 후보로 저장한다.   


# Complexity
- **Time complexity:**     
O(n): 배열의 크기가 n일 때, 한 번의 순차 조회로 끝남

- **Space complexity:**     
O(1): 임시 값들을 저장하기 위한 정수 개의 메모리 공간만 할당 함

# Code
```kotlin []
class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val n = gas.size
        var totalTank = 0   // 전체 가스의 잔량 합
        var currTank = 0    // 현재 이동 중 가스 잔량
        var startIndex = 0  // 출발점 후보

        for (i in 0..(n-1)) {
            // 남은 연료
            val diff = (gas[i] - cost[i])
            currTank += diff
            totalTank += diff

            // 남은 연료가 음수라면, currTank를 0으로 초기화
            if (currTank < 0) {
                currTank = 0
                startIndex = i+1
            }
        }
        return if(totalTank >= 0) startIndex else -1
    }
}

```
