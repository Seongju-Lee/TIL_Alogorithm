[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
47. Permutations II
## Approach
<!-- Describe your approach to solving the problem. -->
재귀를 통해서 순열을 구한다.  
중복순열을 방지하기 위해, 주어진 배열을 정렬한 후 겹치는 값에 한해서 처음에 접근한 값만 순열을 만들게끔 구현.  


## Complexity
- Time complexity: O(n*n!)  
초기 인덱스를 선택하기 위해, 0~(n-1)까지의 반복문을 수행.  
초기 인덱스를 선택하고, 순열을 구하는 과정에서 n번의 재귀 호출.
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    public List<List<Integer>> rec(int[] nums, int depth, int n, List<List<Integer>> ans, List<Integer> list, boolean[] visited) {

        if(depth == n) {
            ans.add(list);
        } else {

            for(int i=0; i<n; i++) {

                if(i>0 && !visited[i-1] && nums[i] == nums[i-1]) continue;
                if(visited[i]) continue;

                list.add(nums[i]);
                visited[i] = true;
                rec(nums, depth+1, n, ans, new ArrayList<>(list), visited);
                visited[i] = false;
                list.remove(list.size()-1);

            }
        }

        return ans;
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        // 재귀
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        return rec(nums, 0, nums.length, ans, new ArrayList<>(), new boolean[nums.length]);
    }
}
```