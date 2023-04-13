[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
45. Jump Game II

## Approach
<!-- Describe your approach to solving the problem. -->
<1번 접근>  
모든 인덱스를 순차적으로 순회하면서, 점프 가능한 거리만큼 거리를 최소화.  
문제는 이 거리를 최소화 시키는 과정이 또, 반복문을 통해서 이루어짐.   
때문에, 시간복잡도가 O(n!)까지 커짐.  
-> 차라리 인덱스 하나씩 탐색하면서, 최대 갈 수 있는 거리만 고려해서 업데이트 해나아가면 되는데 dp배열의 값을 올바르게 채워나가야 한다는 사고에 갇힘.


## Complexity
- 1번 접근 Time complexity: O(n!)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {
    public int jump(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        if(n == 1 && dp[0] == 0) return dp[0];

        for(int i=0; i<n; i++) {
            
            dp[i] = Math.min(dp[i], i);

            if(arr[i]+i >= (n-1)) {
                return dp[i]+1;
            } else {
                for(int j=i+1; j<=(arr[i]+i); j++) {
                    dp[j] = Math.min(dp[i]+1, dp[j]);
                }
                
            }
        }


        return dp[n-1];
    }
}
```