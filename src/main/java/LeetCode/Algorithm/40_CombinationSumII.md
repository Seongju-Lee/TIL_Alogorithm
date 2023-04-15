[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
40. Combination Sum II

## Approach
<!-- Describe your approach to solving the problem. -->
작은값부터 target값이 나올 때까지 더하기 위해, 정렬한 후 처리한다.

## Complexity
- Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Code
```
class Solution {

    public void rec(List<List<Integer>> ans, List<Integer> list, int start, int sum, int[] arr, int target) {

            for(int i=start; i<arr.length; i++) {
                if(sum == target) {
                    ans.add(new ArrayList<>(list));
                    break;
                } else if(sum > target) {
                    break;
                } else {
                    if(i > start && arr[i] == arr[i-1]) continue;
                    list.add(arr[i]);
                    rec(ans, list, i+1, sum+arr[i], arr, target);
                    list.remove(list.size()-1);

                }
            }

            if(start == arr.length && sum == target) {
                ans.add(new ArrayList<>(list));
            }

    }


    public List<List<Integer>> combinationSum2(int[] arr, int target) {

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        rec(ans, list, 0, 0, arr, target);

        return ans;
    }
}
```