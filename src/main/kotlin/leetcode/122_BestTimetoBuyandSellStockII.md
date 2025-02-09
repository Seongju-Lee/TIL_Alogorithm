# Intuition
[122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description)

# Approach
가장 직관적인 해결 방식은 O(n^2)의 시간복잡도를 가지도록 해결 하는 것이었음
- 0번 인덱스부터 (n-1)번까지 (n) + (n-1) + (n - 2) + ... + 1 = n^2

**최종**    
어쨌든 뒤이어 나오는 수와 앞에 나온 수의 차이의 누적 합이 가장 크면 해결되는 문제이다.     
우선, (뒤에 나오는 수 - 앞에 나온 수의 차) 중에 최댓값을 저장한다. 하지만, **최댓값을 계속 누적하며 갱신**하는 것이 고민거리였음    

배열의 처음부터 끝까지 순서대로 for-loop을 돌면서, 현재 인덱스까지의 최댓값을 저장하도록 구현  
이때, **현재 인덱스까지의 최댓값은 둘 중 하나**인 것이다.   
1. 직전 인덱스까지의 최댓값이 그대로 유지
2. 직전 인덱스까지의 최댓값에 새로운 매수/매도 차액이 +인 경우 -> 이 값으로 최댓값 갱신

어쨌든, **첫번째 인덱스의 최댓값은 0이고(당일 매수/매도), 배열의 값들 중 음수는 없으므로, 결국 인덱스 1부터 마지막까지 차액의 누적 합이 가장 크도록 유지만 하면 된다.**


# Complexity
prices의 크기가 n일 때  

- **Time complexity:**    
O(n) - 1 ~ (n-1) 순차 순회함   


- **Space complexity:**    
O(n) - 현재 인덱스까지의 최대 누적합을 저장하기 위한 n크기의 마킹용 배열을 선언하고, 사용 함.   


# Code
```kotlin []
class Solution {
    fun maxProfit(prices: IntArray): Int {
        
        val n = prices.size
        val arr = IntArray(n)

        for (i in 1..(n-1)) {
            arr[i] = maxOf(arr[i-1], arr[i-1]+(prices[i]-prices[i-1]))
        }
        return arr[n-1]
    }
}
```
