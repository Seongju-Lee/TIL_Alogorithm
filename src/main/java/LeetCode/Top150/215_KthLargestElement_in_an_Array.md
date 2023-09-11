[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
215. Kth Largest Element in an Array


## Approach
- PriorityQueue를 사용하여 k번째로 큰 요소 탐색
- 먼저 배열의 모든 요소를 우선순위 큐에 삽입하고, 큐의 크기가 k보다 크면 가장 작은 요소를 제거 -> k개의 요소만 유지
- 큐에는 k번째로 큰 요소부터 내림차순으로 삽입.
- 큐의 맨 위 요소 == k번째 큰 요소

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(NlogK)  
N: 배열 길이
K: 탐색 요소 순서

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 우선순위 큐를 생성하고 배열의 요소를 삽입
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            // 큐의 크기가 k를 초과하면 가장 작은 요소를 제거하여 k개를 유지
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 큐에는 k번째로 큰 요소부터 작은 순으로 들어있으므로 반환
        return minHeap.peek();
    }
}
```
