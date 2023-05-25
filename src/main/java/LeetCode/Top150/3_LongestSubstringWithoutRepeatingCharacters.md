[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
3. Longest Substring Without Repeating Characters


[//]: # (## Approach)

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
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set  = new HashSet<>();
        char[] sArr = s.toCharArray();
        int li=0, ri=0;
        int ans = 0;

        while (ri != sArr.length) {

            // 중복된 값이 없다면, 계속 값으로 추가
            while (ri<sArr.length && !set.contains(sArr[ri])) {
                set.add(sArr[ri]);
                ri++;
            }

            // 중복된 값이 생겼을 때
            ans = Math.max(ans, (ri-li)); // 길이가 더 긴것으로 업데이트
            set.remove(sArr[li]);
            li++;


        }

        return ans;
    }
}
```