[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
45. Jump Game II

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(V+E)  
V: 간선 개수  
E: 노드 개수(이동 가능한 인덱스)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {
    
    public int bfs(int[] nums, int des) {

        // Q의 값: nums배열의 index
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[des+1]; // 경유한 위치 체크

        q.offer(0);
        int depth = 0; // 그래프 깊이: 점프 횟수

        while (!q.isEmpty()) {

            int size = q.size();

            for(int s=0; s<size; s++) { // 같은 depth의 값들

                int location = q.poll();

                if(location == des) { // 현재 위치가 최종 목적지라면
                    return depth; // 현재 점프 횟수 리턴
                }


                // 현재 위치에서 점프 가능한 곳들 모두 Q에 등록
                for(int i=1; i<=nums[location]; i++) {

                    if(location+i >= des) return depth+1;

                    if(!visited[location + i]) { // 경유하지 않은 곳이라면
                        visited[location+i] = true;
                        q.offer(location+i);  // Q에 등록
                    }

                }
              
                
            }

            depth++;
        }

        return depth;
        

    }
    public int jump(int[] nums) {

        // bfs 풀이
        return bfs(nums, nums.length-1);
    }
}
```