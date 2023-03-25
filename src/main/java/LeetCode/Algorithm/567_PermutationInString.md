[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
567. Permutation in String
## Approach
<!-- Describe your approach to solving the problem. -->
s1의 문자 개수만큼 슬라이딩 윈도우 통해서 모든 가능한 문자열 탐색
<br>문자열이 포함되어 있는지 확인하는 것이 아닌,
<br>문자열의 조합이 포함 되어있나 확인하는 것이므로 배열을 사용한다.


## Complexity
- Time complexity: O(n)     -> Two Pointer
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i=0; i<len1; i++) {
            s1Arr[s1.charAt(i)-'a'] += 1;
        }

        for(int i=0; i<len2; i++) {

            s2Arr[s2.charAt(i)-'a'] += 1;

            if(i >= len1) {
                s2Arr[s2.charAt(i-len1) - 'a'] -= 1;
            }

            if(Arrays.equals(s1Arr, s2Arr)) {
                return true;
            }
        }

        return false;
    }
}
```
