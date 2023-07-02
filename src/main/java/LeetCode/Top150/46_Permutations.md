[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
46. Permutations

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(n! == n^n)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        // 중복없는 순열
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(ans, tmp, nums, visited);
        return ans;
        
    }

    private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] nums, boolean[] visited) {
        
        if(tmp.size() == nums.length) {
            // stop
            ans.add(new ArrayList(tmp));
            return;
        }

        for (int i=0; i<nums.length; i++) {

            if(!visited[i]) {

                tmp.add(nums[i]);
                visited[i] = true;
                dfs(ans, tmp, nums, visited);
                tmp.remove(Integer.valueOf(nums[i]));
                visited[i] = false;

            }
        }
    }
}
```