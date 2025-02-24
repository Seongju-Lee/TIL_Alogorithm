# Intuition
[28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description)

# Approach
하나의 인덱스로 처리하려다가 값을 지나칠 수 있다는 것을 깨닫고, 슬라이딩 윈도우로 처리   

컨셉 자체는 아래와 같다.   
1. li와 ri는 haystack의 인덱스로, needle의 문자와 ri의 문자가 일치하는 한 계속 ri를 한 칸씩 이동시키면서 needle 문자와 비교한다.
2. needle 끝까지 이동하면 li를 리턴
3. 중간에 다른 값이 나오면, li를 한 칸 이동시키고 나머지 값들도 초기값으로 셋업

위 방식은 O(n^2) 시간복잡도를 가지지만, [KMP 알고리즘](https://velog.io/@hwan2da/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-KMP-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)을 적용시키면 O(n)으로도 줄일 수 있다.   


# Complexity
- **Time complexity:**    
O(n*m): haystack의 길이가 n이고, li 인덱스의 이동 횟수가 m이라고 할 때, n*m번 반복 수행함.  

- **Space complexity:**    
O(1): index를 다룰 변수를 제외한 추가 메모리 공간을 할당하지 않음. 

# Code
```kotlin []
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        
        val totalSize = haystack.length

        val size = needle.length
        var li = 0
        var ri = 0
        var needleIndex = 0
        while (ri < totalSize) {
            // needle과 값이 일치하는 한 계속 ri를 이동시킨다.
            while (haystack[ri] == needle[needleIndex]) {
                ri++
                needleIndex++
                if (needleIndex == size) { // 일치해서 계속 이동하다가, needle의 끝까지 동일하면,
                    return li // 시작접인 li를 리턴
                } else if (ri >= totalSize) {
                    return -1
                }
            }
            // 그게 아니라면 세팅값 초기화 함과 동시에 li이동
            li++
            ri = li
            needleIndex = 0
        }

        return -1
    }
}
```


- KMP
```kotlin[]
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        val lps = computeLPS(needle)
        var i = 0 // haystack index
        var j = 0 // needle index

        while (i < haystack.length) {
            if (haystack[i] == needle[j]) {
                i++
                j++
                if (j == needle.length) return i - j
            } else {
                if (j != 0) {
                    j = lps[j - 1]
                } else {
                    i++
                }
            }
        }
        return -1
    }

    private fun computeLPS(pattern: String): IntArray {
        val lps = IntArray(pattern.length)
        var length = 0
        var i = 1

        while (i < pattern.length) {
            if (pattern[i] == pattern[length]) {
                length++
                lps[i] = length
                i++
            } else {
                if (length != 0) {
                    length = lps[length - 1]
                } else {
                    lps[i] = 0
                    i++
                }
            }
        }
        return lps
    }
}
```
