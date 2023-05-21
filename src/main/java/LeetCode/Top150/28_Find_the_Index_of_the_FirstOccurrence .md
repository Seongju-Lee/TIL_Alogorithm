[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
28. Find the Index of the First Occurrence in a String


[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n)

[//]: # (- [//]: # &#40;<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->&#41;)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public int strStr(String haystack, String needle) {
        
        char[] arr = haystack.toCharArray();
        int li=0, ri=0;
        
        while (ri != arr.length) {

            
            if(arr[ri] == needle.charAt(0)) { // 첫번째 시작 문자가 동일한게 나온다면 비교 시작
                
                int idx = 0;
                while (arr[ri] == needle.charAt(idx)) {
                    
                    ri++;
                    idx++;

                    if(idx == needle.length()) { // 문자가 다 일치하면 리턴
                        return li;
                    }

                    if(ri >= arr.length) {
                        return -1;
                    }
                }

                li++;
                ri=li;

            } else {
                li++;
                ri++;
            }

            
        }

        return -1;
    }
}
```