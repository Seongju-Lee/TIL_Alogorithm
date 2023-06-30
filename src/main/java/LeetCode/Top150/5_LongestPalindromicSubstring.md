[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
5. Longest Palindromic Substring

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^2)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public String longestPalindrome(String s) {
        
        // 문자열 맨 앞부터 밀고 나간다
        char[] arr = s.toCharArray();
        String[] ans = new String[1];
        ans[0] = "";

        for(int i=0; i<arr.length; i++) {
            expandPalindrome(arr, i, i, ans);
            expandPalindrome(arr, i, i+1, ans);
        }
        return ans[0];
        
    }

    private void expandPalindrome(char[] arr, int i, int j, String[] ans) {

        int l=i, r=j;
        while (l>=0 && r<arr.length && arr[l] == arr[r]) {
            l--;
            r++;
        }

        if(ans[0].length() < (r-l)) {
            ans[0] =  String.valueOf(arr).substring(l+1, r);
        }
    }
}
```