[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
210. Course Schedule II

## Approach
양방향에서 무한으로 참조되는 것을 방지하기 위해, checked 배열을 적절한 위치에 선언/활용한다.
<!-- Describe your approach to solving the problem. -->


## Complexity

- Time complexity: O(n^2)  
n: 주어진 배열의 길이일 때,  
배열의 모든 원소를 탐색하면서, 각 원소에 연결된 인접리스트에서 재귀를 진행한다.  
각 원소(n개와) 연결된 간선의 개수만큼 진행 되므로, O(n(n+e))의 시간복잡도를 구할 수 있다.

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class Solution {

    public boolean dfs(boolean[] isFinished, List<Integer>[] list, List<Integer> ans, int cur, int num, boolean[] checked) {

        if(num == ans.size()) { // 들을 과목 수를 모두 충족 시켰을 때.
            return true;
        }


        for(int i=0; i<list[cur].size(); i++) { // 현재 과목 위해, 들어야할 필수 목록

            if(!isFinished[list[cur].get(i)]) {
                if(checked[list[cur].get(i)]) return false;
                
                checked[list[cur].get(i)] = true;
                if(!dfs(isFinished, list, ans, list[cur].get(i), num, checked)) return false;
            }
        }


        isFinished[cur] = true;
        ans.add(cur);

        return true;
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        /**
        pre 배열: 선행 되어야 할 것들이 모두 풀렸는지.
        0 부터 차례대로, dfs 진행하면서, 선행 목록 중 만족하지 못한 번호가 나오면 dfs 진행.
         */
        
        boolean[] isFinished = new boolean[numCourses];

        List<Integer>[] list= new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            list[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites) { // 인접 리스트: i번을 수행하기 위해, list.get(i)를 모두 수행 필수.
            list[pre[0]].add(pre[1]);
        }
        

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            if(isFinished[i]) continue;
            
            boolean[] checked = new boolean[numCourses];
            if(!dfs(isFinished, list, ans, i, numCourses, checked)) {
                return new int[0];
            }        
        }

        int[] arr = ans.stream().mapToInt(i -> i.intValue()).toArray();
        return arr;
    }
}
```