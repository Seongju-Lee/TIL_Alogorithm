# Intuition
[151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description)

# Approach
처음엔 투포인터로 변경하는걸 고려함. 하지만, 중간에 들어있는 공백때문에 조건이 까다로워짐    

그래서, 빈 문자열을 하나 선언하고 0번부터 순차 순회하며, 한 문자열이 생길때마다 문자열 앞쪽에 추가하는 방식으로 해결  
이때, 문자열을 추가함과 동시에 공백도 맨 앞에 추가함 -> 마지막 return 식에서 맨 앞에 공백을 제외하고 리턴. 


# Complexity
- **Time complexity:**    
O(n): 입력으로 주어진 문자열 s의 길이가 n일 때, 문자열 인덱스 하나씩 순차 조회하며 처리

- **Space complexity:**    
O(1): 값을 저장할 변수 네 개를 제외한 메모리 공간을 추가로 사용하지 않음    

# Code
```kotlin []
class Solution {
    fun reverseWords(s: String): String {
        var ans = ""
        var pre = 0
        var cur = 0
        val length = s.length
        while (cur < length) {    
            if (s[cur] == ' ' && s[pre] == ' ') {
                cur++
                pre = cur
                continue
            } else if (s[cur] == ' ') {
                ans = " ${s.substring(pre, cur)}${ans}"
                pre = cur+1
            }
            cur++
        }

        if (cur == length) {
            ans = "${s.substring(pre, cur)}${ans}"
        }

        return if (ans[0] == ' ') {
            return ans.substring(1, ans.length)
        } else {
            return ans
        }
    }
}
```
