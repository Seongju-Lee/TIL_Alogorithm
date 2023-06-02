[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
205. Isomorphic Strings

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
    public boolean isIsomorphic(String s, String t) {
        
        int n = s.length();

        int[] sArr = new int[128];
        int[] tArr = new int[128];

        for (int i=0; i<n; i++) {

            if(sArr[s.charAt(i)] != tArr[t.charAt(i)]) {
                return false;
            }

            // i가 0인 경우 -> 인덱스가 0인지, 값이 없는 지 확인 불가
            sArr[s.charAt(i)] = i+1;
            tArr[t.charAt(i)] = i+1;
        }
        
        
        return true;
    }
}
```