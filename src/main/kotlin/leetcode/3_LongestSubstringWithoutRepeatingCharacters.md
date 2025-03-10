# Problem
[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description)

# Approach
1. 일단 현재 인덱스의 문자가 앞서 나온 문자인지 확인할 필요가 있다.    
    1.1 Map을 사용하여 O(1)의 시간복잡도로 비교할 수 있도록 함
2. substring 특성상, 중복되지 않은 연속된 문자 나열을 계속해서 비교해야 한다.   
    2.1 중복이 없을 때까지, ri를 우선 이동한다. (여기서 ri는 투포인터의 오른쪽 인덱스)    
    2.2 ri를 이동하면서 ri에 위치한 문자가 앞서 나온 문자라면, ri 문자와의 중복이 없어질 때까지 li를 이동시킨다.    
    2.3 물론, 2.2에서 ri가 중복된 순간에 (li ~ ri)까지의 길이가 최대 substring 길이 값인지 비교분석한다.


# Complexity
- **Time complexity:**
O(n): 문자열의 길이를 n이라고 할 때, 기본적으로 n만큼 ri가 이동한다. 또한, 중복된 데이터가 발생할때마다 li도 최대 n만큼 이동할 수 있다. 따라서, 최대 각 문자를 2번씩 방문할 수 있으므로 O(2*n) 시간복잡도를 가짐  

- **Space complexity:**
O(n): 슬라이딩 윈도우를 수행하며, 중복 여부를 체크하기 위한 Map 자료구조를 가진다. 최악의 경우, 중복된 데이터가 없다면 해당 Map에 문자열의 길이만큼 메모리를 할당하여 키-값을 저장한다.  

# Code
```kotlin []
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Boolean>()

        var li = 0
        var ri = 0
        val n = s.length
        var maxLen = 0
        while (ri < n) { 
            
            val current = s[ri]
            if (map[current] == true) {
                // 중복 없어질 때까지 li를 이동시킴
                while (s[li] != current) {
                    map[s[li]] = false
                    li++
                }
                // 내부 while문에서 중복된 문자를 만나고 나서, 탈출했으니 li를 하나 더 이동
                map[s[li]] = false
                li++
            }

            map[current] = true
            ri++
            maxLen = maxOf(maxLen, ri-li)
        }
        
        return maxLen
    }
}
```
