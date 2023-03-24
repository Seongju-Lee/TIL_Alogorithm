[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
3. Longest Substring Without Repeating Characters
## Approach
<!-- Describe your approach to solving the problem. -->
Two pointer를 활용했다.<br>
ri를 한 인덱스씩 이동시키면서, set에 중복된 문자가 존재하면 ri를 멈추고, li를 이동시키는 로직으로 풀이.

## Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int answer=0, count=0;
        int ri=0, li=0;

        while ( ri != s.length() ) {

            if(set.contains(s.charAt(ri))) {

                set.remove(s.charAt(li));
                count--;
                li++;
                
            } else {

                set.add(s.charAt(ri));
                count++;
                answer = Math.max(answer, count);
                ri++;
            }
        }
        return answer;
        
    }
}
```