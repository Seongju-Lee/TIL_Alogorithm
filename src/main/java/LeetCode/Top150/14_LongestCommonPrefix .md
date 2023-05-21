[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
14. Longest Common Prefix

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n*m)  
n: strs의 길이  
m: prefix의 길이

[//]: # (- [//]: # &#40;<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->&#41;)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];
        for (String str : strs) {

            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
            }

            if(prefix.equals("")) {
                break;
            }

        }

        return prefix;
    }
}
```