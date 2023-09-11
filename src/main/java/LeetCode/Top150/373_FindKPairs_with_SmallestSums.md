[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
373. Find K Pairs with Smallest Sums


## Approach
- 최소 힙(minHeap)을 사용하여 합이 가장 작은 쌍을 추적
- nums1 배열의 첫 번째 요소와 nums2 배열의 모든 요소를 조합하여 최소 힙에 삽입
- k번째까지 작은 합을 가지는 쌍을 추출하고, 결과 리스트에 추가
- nums2에서 다음 요소를 선택하여 새로운 쌍을 생성하고 다시 최소 힙에 삽입
[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(klog(n))

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        
        // 최소 힙을 사용하여 합이 가장 작은 쌍을 추적
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // nums1의 첫 번째 요소와 nums2의 모든 요소를 조합하여 minHeap에 삽입
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        // k번째까지 작은 합을 가지는 쌍을 추출
        while (k > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int num1 = pair[0];
            int num2 = pair[1];
            int index2 = pair[2];
            
            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(num1);
            currentPair.add(num2);
            result.add(currentPair);
            
            if (index2 < nums2.length - 1) {
                minHeap.offer(new int[]{num1, nums2[index2 + 1], index2 + 1});
            }
            
            k--;
        }
        
        return result;
    }
}

```
