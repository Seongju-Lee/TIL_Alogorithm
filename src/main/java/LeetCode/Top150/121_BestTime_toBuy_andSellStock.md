[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
121. Best Time to Buy and Sell Stock

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
    public int maxProfit(int[] prices) {
        
        int li=0, ri=0, ans=0;

        while (ri != prices.length-1) {

            if(prices[li] > prices[ri]) {
                li = ri;
            }

            ri++;
            ans = Math.max(ans, (prices[ri]-prices[li]));

        }

        return ans;
    }
}
```