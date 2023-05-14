[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
274. H-Index

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
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;
        int ans = 0;

        for(int i=0; i<n; i++) {


            int cur = citations[i]; // 현재 값

            ans = Math.max(ans, Math.min(n-i, cur));
            while ( (i+1)<n && citations[i+1] == cur) {
                i++;
            }

        }

        return ans;

    }
}
```