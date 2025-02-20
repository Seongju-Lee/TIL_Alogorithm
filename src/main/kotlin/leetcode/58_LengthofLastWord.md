# Intuition
[58. Length of Last Word](https://leetcode.com/problems/length-of-last-word/description)

# Approach
맨 뒤 문자열부터 하나씩 인덱싱 하며, 첫 공백이 아닌 순간부터 문자를 하나씩 붙여 하나의 단어를 완성 시킨다.  


# Complexity
- **Time complexity:**    
O(n): 문자열 s의 길이가 n일 때, 모든 값 최대(첫 문자를 제외한 나머지가 공백인 경우) n번 순회하며 처리함

- **Space complexity:**     
O(1): 2개의 변수를 제외한 추가적인 메모리 공간을 할당하지 않음  

# Code
```kotlin []
class Solution {
    fun lengthOfLastWord(s: String): Int {

        val len = s.length
        var ans = ""
        for (i in (len-1) downTo 0) {
            if (s[i] == ' ') {
                if (ans != "") return ans.length
            } else {
                ans = s[i] + ans
            }
        }

        return ans.length
    }
}
```
