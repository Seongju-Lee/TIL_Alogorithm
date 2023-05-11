[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
169. Majority Element

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n)   
[n/2]라는 점을 훌륭하게 활용한 풀이

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public int majorityElement(int[] nums) {
        
        int k = 0, cnt=0;
        for(int i=0; i<nums.length; i++) {
            
            // 최대 원소는 [n/2]이상이라는 조건이 있으므로, 
            // 가령, cnt를 100까지 올렸던 값이 다른 여러 원소들로 인해 cnt가 0이 되고,
            // cnt가 0인 순간에 처음나온 원소를 만나 답이 될 가능성 ===> 절대 없음.
            
            if(cnt == 0) { // 지금까지 최대였던 원소가 무효화 됨.
                k = nums[i];
                cnt= 1;
            } else if(nums[i] == k) { // 현재 최대 원소의 개수 1추가
                cnt++;
            } else { // 현재 최대원소가 아닌 새로운 원소가 나타난 경우
                cnt--;
            }
        }

        return k;
    }
}
```