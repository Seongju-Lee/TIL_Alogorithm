[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
151. Reverse Words in a String

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
    public String reverseWords(String s) {
        
        String[] arr = s.trim().split(" ");

        int li=0, ri=arr.length-1;
        while (li < ri) {

            // li와 ri를 변경하면서, li와ri의 간격을 좁혀 나감.

            String tmp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = tmp;

            li++;
            ri--;

        }

        StringBuilder sb = new StringBuilder();
        for(String str : arr) {

            if(!str.equals("")) {
                sb.append(str).append(" ");
            }
        }


        return sb.toString().trim();
    }
}
```