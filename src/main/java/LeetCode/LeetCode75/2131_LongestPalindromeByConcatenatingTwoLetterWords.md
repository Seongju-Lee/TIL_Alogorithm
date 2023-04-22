[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
2131. Longest Palindrome by Concatenating Two Letter Words

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^n): 재귀 방식   
시간 복잡도 비교를 위해 재귀 방식 구현.
- Time complexity: O(n): 그리디 방식.

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    /**
    words: 주어진 배열
    arrLen: 현재 탐색 중인 words의 인덱스
    maxLen: 만들고자 하는 문자열의 길이
    str: 만들고 있는 문자열
    visited: 이미 str 문자열에 추가 했는지 여부
     */

    static int ans;
    public boolean isPal(String[] words, int maxLen, String str, boolean[] visited) {

        if(str.length() == maxLen) { // 문자열 길이를 만족하면  
            // 팰린드롬인지 확인 (무조건 짝수개의 문자)

            int right = str.length()/2;
            int left = right-1;

            while (right < str.length() && left >= 0) {

                if(str.charAt(left) != str.charAt(right)) return false;

                left--;
                right++;
            }

            
            ans = str.length();
            return true;
        } else {

            for(int i = 0; i<words.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    if(isPal(words, maxLen, str+words[i], visited)) return true;
                    visited[i] = false;
                    
                }
            }
        }

        return false;
    }

    public int longestPalindrome(String[] words) {
        
        
        int len = words.length; // 주어진 배열의 길이

        for(int i=len; i>=0; i--) { // 최대 길이의 팰린드롬부터 만들어 봄.

            String str = "";
            if(isPal(words, i*2, str, new boolean[len])) {
                return ans;
            }
        }

        return 0; // 위 반복문에서 return 안되면 팰린드롬이 없다는 의미.
    }
}
```