[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
122. Best Time to Buy and Sell Stock II

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n^2)
- Time complexity: O(n)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public void dfs(int[] prices, int li, int ri, int profit, int[] ans, int fix) {
        
        if(ri == prices.length) return;

        // 가변적인 ri가 불변인 li의 값보다 큰 경우
        if(prices[ri] > prices[li]){
            
            // 현재 ri에 대한 최대 수익 탐색
            for(int i=ri; i<prices.length; i++) {
                
                if(prices[i] < prices[li]) {
                    li = i;
                }
                else if(prices[i] > prices[li]) {
                    profit += (prices[i] - prices[li]);
                    // System.out.println(fix +"-> "+ prices[i] +", " + prices[li] +", "+ profit);
                    li = i;
                }
            }
            ans[0] = Math.max(ans[0], profit); // 최대수익과 현재수익 비교

        }

        // ri 변경
        dfs(prices, fix, ri+1, 0, ans, fix); 


    }

    public int maxProfit(int[] prices) {
        
        int[] ans = new int[1];
        for(int i=0; i<(prices.length-1); i++) {
            dfs(prices, i, i+1, 0, ans, i);
        }

        return ans[0];
        
    }
}
```
```
class Solution {
public int maxProfit(int[] prices) {

        int[] dp = new int[prices.length];

        dp[0] = 0;
        
        for (int i=1; i<prices.length; i++) {

            dp[i] = Math.max(dp[i-1]+(prices[i]-prices[i-1]), dp[i-1]);

        }

        return dp[dp.length-1];
    }
}
```