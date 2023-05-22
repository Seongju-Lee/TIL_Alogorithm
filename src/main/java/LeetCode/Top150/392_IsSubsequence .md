[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
392. Is Subsequence


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
    public boolean isSubsequence(String s, String t) {
        
        int idx = 0;

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        if(ss.length == 0) return true;

        for(int i=0; i<tt.length; i++) {

            if(idx < ss.length && ss[idx] == tt[i]) {

                if(idx == ss.length-1) {
                    return true;
                }

                idx++;

            }
        }


        return false;
        
    }
}
```