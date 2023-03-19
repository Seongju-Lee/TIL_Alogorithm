[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
278. First Bad Version
## Approach
<!-- Describe your approach to solving the problem. -->
특정 인덱스 값 이후부터는 모두 true이고, true가 처음으로 나오는 인덱스를 찾는 문제.
<br>Linear Scan시, TLE가 발생.
<br>이진탐색은 통해 값을 조회하면서, int형의 overflow를 방지하기 위 long으로 형변환.
<br>형변환보다 메모리를 덜 쓰기 위해선 아래와 같은 수식 적용 가능.
<br><br> <b> (lv+rv)/2  -> lv + ((rv-lv)/2)

## Complexity
- Time complexity: O(logN)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        long lv=1, rv=n;
        // int lv=1, rv=n;
        while (lv <= rv) {
            long mid = (lv+rv)/2;
            // int mid = lv + (rv-lv)/2; 위와 같은 수식.

            if(isBadVersion((int) mid))
                rv = mid-1;
            else
                lv = mid+1;
        }
        
        return (int) rv+1;
    }
}
```