[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
17. Letter Combinations of a Phone Number
## Approach
<!-- Describe your approach to solving the problem. -->
각 번호에 따라 문자 리스트를 매핑한 후, 주어진 문자의 번호와 매핑된 리스트간의 재귀를 통해 가능한 조합을 모두 찾아낸다.

## Complexity
- Time complexity: O(4^N)  
재귀를 이용하는 방식이다. 한 번호와 매핑되는 최대 문자의 길이는 4이다.  
예를 들어, 문자 길이가 4인 리스트 4개(a,b,c,d)를 재귀를 통해 모든 경우의 수를 찾는다고 가정하자.  
- 최초 a 리스트에서 문자 하나씩 뽑는데 걸리는 시간.O(4^0)
- a 리스트에서 네 번 b 리스트와 조합.O(4^1)
- b 리스트에서 네 번 c 리스트와 조합.O(4^2)
- c 리스트에서 네 번 d 리스트와 조합.O(4^3)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
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