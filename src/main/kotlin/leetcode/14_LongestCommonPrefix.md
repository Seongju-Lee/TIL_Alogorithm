# Intuition
[14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/description)

# Approach
최대로 긴 prefix를 찾아야 한다. 이때, 최대 가능한 문자열의 길이는 배열의 요소중 가장 길이가 짧은 문자열이 된다.   

배열을 반복하되, 반복문 내부에서 현재까지 가장 긴 문자열과 현재 요소의 문자를 하나씩 비교해 나아간다. 중요한건 어쨌든 현재까지 가장 긴 문자열이 답이 될 수 있는 후보인 것임(현재 요소의 문자열이 아니라)    

코드를 보면, 첫번째 for문 안에 마지막 조건문에 등호가 있다. 길이가 같으면 굳이 안바꿔도 되나 싶지만, 문자열이 비어있을 때를 고려하면 등호를 넣어야 한다. (최초 시작하는 문자열이 첫번째 인덱스의 문자열이기 때문)

# Complexity
- **Time complexity:**     
O(n*m): 배열의 길이가 n이고 배열의 요소 중 가장 짧은 문자열의 길이가 m이라고 할 때, n*m번 반복문 수행   

- **Space complexity:**     
O(1): 정답 변수, 길이 저장할 지역 변수 등을 위한 메모리 공간만 할당함   

# Code
```kotlin []
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
    
        var ans = strs[0]
        for (str in strs) {
            var minLen = minOf(ans.length, str.length)
            var len = 0
            for (i in 0..(minLen-1)) {
                if (ans[i] == str[i]) len++
                else break
            }

            if (len <= minLen) {
                ans = str.substring(0, len)
                minLen = len
            }
        }
        return ans
    }
}
```
