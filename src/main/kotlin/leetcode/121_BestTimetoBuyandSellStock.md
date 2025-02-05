# Intuition
[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)

# Approach
결국에는 뒤이어 나올 값과 앞서 나온 값의 차이 중에 가장 큰 차이를 정답으로 도출하라는 문제다.  

가장 큰 차이를 만들어낼 수 있는 방법은 **가장 큰 값에서 가장 작은 값을 빼면**된다.   
즉, 아래와 같은 상태 값을 저장한다.   

- `result`: 결과 즉, 최대 차이값을 저장
- `min`: 현재까지 가장 작은 값을 저장
- `price`: 현재 값
- `diff`: 현재값(`price`) - 최솟값(`min`)

위와 같은 값들이 있을 때, `prices` 배열의 첫 원소부터 차례대로 원소(`price`)를 하나씩 추출한다고 해보자.  

결국 `diff`와 `result`를 비교해가며 `result` 값을 업데이트하면 된다.   
즉, **현재 값(`price`)이 가장 크면 가장 큰 차이를 만들어 내는 것**이다.   

# Complexity
- **Time complexity:**    
O(n): prices 배열에서 원소를 하나씩 추출해가며 값을 비교연산 하는 로직이므로 `prices`의 크기가 n이라고 할 때, O(n) 시간복잡도를 가짐

- **Space complexity:**    
O(1):  `result`, `min`, `price`는 모두 정수변수로 총, 상수 개수만큼의 메모리 공간을 할당한다.  
`diff`는 for-loop 내의 지역변수로, 메모리 사용량은 일정하다. 즉, 배열 크기와 무관하게 추가적인 메모리 공간을 할당받지 않음   


# Code
```kotlin []
class Solution {
    fun maxProfit(prices: IntArray): Int {

        // result: 최대 차이액을 저장
        var result = 0
        var min = prices[0]

        for (price in prices) {
            if (price > min) {
                val diff = (price-min)
                result = if (result < diff) diff else result
            } else {
                min = price
            }
        }
        return result

    }
}
```
