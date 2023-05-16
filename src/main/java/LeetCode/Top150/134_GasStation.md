[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
134. Gas Station

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
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for (int start=0; start<gas.length; start++) {
            
            if (gas[start] >= cost[start]) { // 출발도 못하는 startPoint는 넘긴다.

                int end = go(gas, cost, start); // start에서 출발해서 최대한 간 위치

                if(start == end) {
                    return start;
                } else if(start > end) {
                    return -1;
                }

                start = end; // Greedy
            }
        }

        return -1;

    }

    private int go(int[] gas, int[] cost, int end) {
        
        int tank = gas[end]-cost[end]; // 처음에 한 칸 이동후, 남은 가스량 
        int cur = end+1; // 처음에 한칸 이동.
        if(cur == gas.length) cur=0;

        tank += gas[cur]; // 이동 후, 가스 충전


        while (cur != end) { // 현재 위치가 목적지와 동일하기 전까지 반복
            
            // 가스 소모
            tank -= cost[cur];
            if(tank < 0) return cur; // 소모 뒤, 가스가 없으면 멈춘 위치 리턴.

            // 위치 이동
            if(cur == (gas.length-1)) {
                cur = 0;
            } else {
                cur++;
            }
            
            // 가스 충전
            tank += gas[cur]; 



        }

        return cur;
    }
}
```