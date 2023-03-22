[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
557. Reverse Words in a String III
## Approach
<!-- Describe your approach to solving the problem. -->
여러 문자열을 reverse 하여 하나의 문자열로 합치는 문제


## Complexity
- Time complexity: O(n^2)<br>
  ( -> StringBuilder의 Time Complexity가 O(n) )
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        for(String str : s.split(" ")) {

            StringBuilder reverseWord = new StringBuilder(str);
            sb.append(reverseWord.reverse()).append(" ");
        }

        return sb.toString().strip();
    }
}
```