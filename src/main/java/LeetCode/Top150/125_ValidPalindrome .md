[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
125. Valid Palindrome


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
    public boolean isPalindrome(String s) {

        String str = s.replaceAll("[^A-Z ^a-z ^0-9]" , "").replace(" ", "").toLowerCase();

        int li=0, ri=str.length()-1;
        while (li < ri) {

            if(str.charAt(li) != str.charAt(ri)) {
                return false;
            }

            li++;
            ri--;
        }

        return true;
    }
}
```