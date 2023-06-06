[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
56. Merge Intervals

[//]: # (## Approach)

[//]: # ()
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
    public int[][] merge(int[][] intervals) {
        

        Arrays.sort(intervals , (arr1, arr2) -> {

            if(arr1[0] == arr2[0]) return arr1[1] - arr2[1];
            else return arr1[0] - arr2[0];

        });

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            // 리스트가 비어있거나, list.lastEnd와 interval[0]이 안겹치면
            if(ans.isEmpty() || (!ans.isEmpty() && ans.get(ans.size()-1)[1] < interval[0])) {
                ans.add(interval); // 리스트에 interval 통으로 삽입 
            } else {

                // list.lastEnd, interval[1] 중 더 큰 것을 리스트 마지막인덱스End로 변경
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], interval[1]);
            }


        }
        

        return ans.toArray(new int[0][]);

    }
}
```