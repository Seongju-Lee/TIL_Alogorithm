[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
14. Longest Common Prefix

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(N^2)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if(prefix == "") break;
        }
        return prefix;
    }
}
```

```
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String ans = "";
        
        // strs을 문자열 길이 순으로 정렬한다.
        Arrays.sort(strs, (s1, s2) -> {return s1.length()-s2.length();});

        // 0번 인덱스의 문자열 길이만큼 반복한다.
        for(int i=0; i<strs[0].length(); i++) {

            char except = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(strs[j].charAt(i) != except) {
                    return ans;
                }
            }
            ans += except;
        }
        
        return ans;
    }
}
```