# Intuition
[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/description)

# Approach
왼쪽에서 무조건 큰 수부터 정의하되, 오른쪽이 더 큰 수가 나오면 (오른쪽 수 - 왼쪽 수)인 규칙을 가짐    
이걸 토대로 구현해도 되나, 사실 각 인덱스에 상징되는 심볼의 각 값의 총 합을 구하면 됨    

때문에 아래와 같이 해결 가능 함
1. 각 인덱스에 해당하는 값을 누적하면서 더하는 것을 기본 원칙으로 가져감
2. 만약, 바로 다음에 오는 값이 더 큰 수를 의미한다면 현재 인덱스의 값을 뺌.  


# Complexity
- **Time complexity:**.   
O(n): 문자열의 길이를 n이라고 할 때, 각 원소를 한번씩 순회

- **Space complexity:**       
O(1): 입력 크기 n에 비례하는 추가 공간을 사용하지 않음(symbol을 7개의 키-값 등) 

# Code
```kotlin []
class Solution {
    fun romanToInt(s: String): Int {
        val symbols = mapOf(
            'I' to 1, 'V' to 5, 'X' to 10,
            'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
        )

        var sum = 0
        val len = s.length

        for (i in 0..(len-1)) {
            val curr = symbols[s[i]] ?: 0
            val next = if (i < len - 1) symbols[s[i + 1]] ?: 0 else 0

            if (curr < next) {
                sum -= curr
            } else {
                sum += curr
            }
        }
        return sum
    }
}

```
