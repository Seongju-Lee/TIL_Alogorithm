# Intuition
[392. Is Subsequence](https://leetcode.com/problems/is-subsequence/description)

# Approach

- 우선, 문제 조건에 s가 t보다 짧다는 보장이 없다. 따라서 early return으로 false 처리   
- 문자열 t를 기준으로 한 문자씩 loop를 통해 접근한다.  
- s의 인덱스, t의 인덱스 두 개를 두고 -> s의 인덱스는 t에서 같은 문자가 발견되기 전까지 움직이지 않음
- 반복문 내부
    - sIndex가 sLen과 동일하면 바로 리턴
    - 현재 t의 값과 현재 s의 값이 동일하면 s의 인덱스를 다음으로 넘어감
    - t의 인덱스는 무조건 증가
- s의 끝까지 도달했으면 while문에서 리턴 되었으므로 무조건 false
가 아니라 **마지막 문자에서 동일했졌을 가능성**도 포함해야 함

# Complexity
- **Time complexity:**   
O(n): t의 문자열 길이가 n일 때, t의 문자열 길이만큼 반복하며 로직을 수행하므로   

- **Space complexity:**    
O(n): 각 문자열의 현재 위치를 저장하기 위한 상수 개의 변수만 할당   

# Code
```kotlin []
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        val sLen = s.length;
        val tLen = t.length;

        if (sLen > tLen) return false

        var sIndex = 0
        var tIndex = 0
        while (tIndex < tLen) {
            if (sIndex == sLen) return true

            if (s[sIndex] == t[tIndex]) {
                sIndex++
            }

            tIndex++
        }
        return sIndex == sLen
    }
}
```
