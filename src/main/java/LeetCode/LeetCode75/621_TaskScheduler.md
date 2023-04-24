[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
621. Task Scheduler

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
    public int leastInterval(char[] tasks, int n) {
        
        int[] times = new int[26];

        int max = 0;
        for (char c : tasks) {
            times[c - 'A']++;
            if(max < times[c - 'A']) max = times[c - 'A'];
        }

        int maxLen = (max-1)*(n+1);
        int allTime = tasks.length;
        int addition = 0;
        
        for(int i : times) {
            if(i == max)
                addition++;
        }
        return Math.max(allTime , maxLen+addition);
    }
}
```