[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
228. Summary Ranges

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
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(nums.length == 0) {
            return ans;
        } else if (nums.length == 1) {
            sb.append(nums[0]);
            ans.add(sb.toString());
            return ans;
        }



        int li=0, ri=1;
        while (ri != nums.length) {

            // ri가 이동하면서 연속적이지 않은 수라면,
                // li == ri-1 라면, "li"를 저장
                // "li -> (ri-1)"을 저장
                // --> li를 ri로 이동
            

            if (nums[ri]-nums[ri-1] != 1) {

                sb = new StringBuilder();

                if(li == (ri-1)) {
                    sb.append(nums[li]);
                    ans.add(sb.toString());
                }

                else {
                    sb.append(nums[li]).append("->").append(nums[ri-1]);
                    ans.add(sb.toString());
                }

                li = ri;
            }

            ri++;

        }


        sb = new StringBuilder();

        if(li == (ri-1)) {
            sb.append(nums[li]);
            ans.add(sb.toString());
        } else {
            sb.append(nums[li]).append("->").append(nums[ri-1]);
            ans.add(sb.toString());
        }

        return ans;
    }
}
```