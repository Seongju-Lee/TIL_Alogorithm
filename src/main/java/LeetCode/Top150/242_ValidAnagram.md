[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
242. Valid Anagram

[//]: # (## Approach)

[//]: # ()
[//]: # (<!-- Describe your approach to solving the problem. -->)

## Complexity

- Time complexity: O(n)   

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public boolean isAnagram(String s, String t) {
        
        // 기본적으로 s의 길이가 더 길면 anagram 형성 불가
        if(t.length() < s.length()) return false;

        // 문자열 s 내부의 각 문자의 개수를 매핑
        int[] sMap = new int[26];
        for(char c : s.toCharArray()) {
            sMap[c-'a']++;
        }


        // s의 문자 구성을 확인해보며, 특정 문자가 t에 있는 개수보다 작으면 false 반환
        for(char c : t.toCharArray()) {

            sMap[c-'a']--;

            if(sMap[c-'a'] < 0) return false;

        }

        return true;
    }
}
```