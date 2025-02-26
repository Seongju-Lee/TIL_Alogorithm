# Intuition
[125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description)

# Approach
문자열의 양쪽 끝에서 값을 비교해가며 팰린드롬 여부를 판단

# Complexity
- **Time complexity:**    
O(n): 문자열 s의 길이가 n일 때, 최대 n번 순회하며 작업을 수행(한쪽 끝에만 문자고, 나머지가 특수문자인 경우)    

- **Space complexity:**    
O(1): 인덱싱이나 상태를 저장하는 변수를 상수개 선언

# Code
```kotlin []
class Solution {
    fun isPalindrome(s: String): Boolean {
        val lowerText = s.lowercase()

        var li = 0
        var ri = lowerText.length-1
        var isPass = false

        while (li < ri) {
            val left = lowerText[li]
            val right = lowerText[ri]

            if (!left.isLetter() && !left.isDigit()) {
                li++
                isPass = true
            }
            if (!right.isLetter() && !right.isDigit()) {
                ri--
                isPass = true
            }
            
            if (!isPass) {
                if (left != right) return false
                li++
                ri--
            }
            
            isPass = false
        }
        return true
    }
}
```
