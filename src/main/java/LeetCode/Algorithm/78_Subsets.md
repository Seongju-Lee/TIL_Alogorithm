[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
78. Subsets
## Approach
<!-- Describe your approach to solving the problem. -->
공집합의 상태부터, 각 인덱스에 대해 두 가지 경우만 생각한다.  
선택한다 or 선택 안한다.

## Complexity
- Time complexity: O(n!)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    public List<List<Integer>> solution(int n, int depth, int[] nums, List<Integer> list, List<List<Integer>> ans) {

        if(depth == n) {
            ans.add(list);
        } else {

            list.add(nums[depth]);
            solution(n, depth+1, nums, new ArrayList<>(list), ans);
            list.remove(list.size()-1);
            solution(n, depth+1, nums, new ArrayList<>(list), ans);

        }

        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        int n = nums.length; // 원소의 개수
        List<List<Integer>> answer = new ArrayList<>();
        // answer.add(new ArrayList<>());
        return solution(n, 0, nums, new ArrayList<>(), answer);

    }
}
```