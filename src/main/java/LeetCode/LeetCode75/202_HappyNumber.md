[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
202. Happy Number

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


[//]: # (## Complexity)

[//]: # (- Time complexity: O&#40;1&#41;)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public boolean isHappy(int n) {
        
        int tmp = n;
        Set<Integer> set = new HashSet<>();

        while (!set.contains(tmp)) {

            set.add(tmp);
            tmp = 0;

            for(int i=0; i<s.length(); i++) {
                int idxVal = s.charAt(i) - '0';
                tmp += idxVal*idxVal;
            }

            if(tmp == 1) return true;

        }

        return false;
    }
}
```