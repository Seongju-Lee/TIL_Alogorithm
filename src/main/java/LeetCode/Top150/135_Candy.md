[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
135. Candy

[//]: # (## Approach)

[//]: # ()
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
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        // 1. 1부터 출발, i-1과 비교해서 더 크다면,
            // max([i], [i-1]+1)으로 [i] 변경
        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1]) {
                ans[i] = Math.max(ans[i], ans[i-1]+1);
            }
        }


        // 2. 끝부터 출발, i+1과 비교해서 더 크다면,
            // max([i], [i+1]+1)으로 [i] 변경
        for(int i=(n-2); i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                ans[i] = Math.max(ans[i], ans[i+1]+1);
                
            }
        }

        // 3. 모든 사탕의 수
        int sum=0;
        for(int i : ans) {
            sum += i;
        }

        return sum;
    }
}
```