[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
162. Find Peak Element

## Approach
정렬도 안되어 있어, 이분탐색이 안될 것 같지만  
문제 조건을 보고 잘 생각해보면 이분탐색으로 접근이 가능한 문제이다.  

엣지 케이스에 대한 정보가 주어져 있으며, 양 옆에 수는 현재 위치의 수보다 무조건 작거나 크다.  
즉, 연속된 수가 올 수 없으므로 양쪽에 자신보다 큰 쪽으로 이동하면 무조건 답이 나온다.  
**만약, 왼쪽으로 값이 계속 커서 왼쪽으로 계속 이동한다 하더라도 0번인덱스가 정답이 될 수 밖에 없는 구조이다. (오른쪽 이동도 마찬가지)**

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(log(n))

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public int findPeakElement(int[] nums) {
        

        int li=0, ri=nums.length-1; // li: 첫번째 인덱스, ri: 마지막 인덱스
        
        if(ri == 0) return 0;

        while (li <= ri) {
            
            int mi = (li+ri)/2;

            if(mi == 0) {
                if(nums[1] < nums[0]) return mi;
                else {
                    li = mi+1;
                }
                
            } else if(mi == nums.length-1) {
                if(nums[mi] > nums[mi-1]) return mi;
                else {
                    ri = mi-1;
                }
                
            } else if(nums[mi] > nums[mi+1] && nums[mi] > nums[mi-1]) {
                return mi;
            } else {

                if(nums[mi+1] < nums[mi-1]) {
                    ri = mi-1;
                } else {
                    li = mi+1;
                }
            }
        }
        return 0;  
    }
}
```
