[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
3. Longest Substring Without Repeating Characters


## Approach
슬라이딩 윈도우  
- 중복되는 문자가 존재하면 안되므로, Set을 사용한다.  
- ri를 이동 시키면서 최초로 중복이 발생한다면 ri위치의 문자가 중복이 사라질 때까지 substring을 하나씩 줄여나간다.  
- ri가 이동하는 시점은 최대길이의 여부를 계속해서 판단한다.

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
        
        Set<Character> map = new HashSet<>();
        int li=0, ri=0;
        char[] arr = s.toCharArray();
        int ans = 0;
        
        while (ri < arr.length) {
            while (map.contains(arr[ri])) {
                // false가 될 때 까지 li 이동
                map.remove(arr[li]);
                li++;
            }

            map.add(arr[ri]);
            ri++;
            ans = Math.max(ans, (ri-li));
        }
        return ans;
    }
}
```