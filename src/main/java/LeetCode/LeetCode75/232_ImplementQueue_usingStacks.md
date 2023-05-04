[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->


# LeetCode
___
232. Implement Queue using Stacks

[//]: # (## Approach)

[//]: # (<!-- Describe your approach to solving the problem. -->)


## Complexity

- Time complexity: O(1)

[//]: # (<!-- Add your time complexity here, e.g. $$O&#40;n&#41;$$ -->)

[//]: # ()
[//]: # ([//]: # &#40;- Space complexity:&#41;)
[//]: # (<!-- Add your space complexity here, e.g. $$O&#40;n&#41;$$ -->)

## Code
```
class State implements Comparable<State>{
    public int t;
    public char state;

    public State(int t, char s) {
        this.t = t;
        this.state = s;
    }

    public int compareTo(State s) {
        if(s.t != this.t) return this.t - s.t; // 시간 순서대로
        else return s.state - this.state; // 시간이 같다면, e보다 s먼저 나오도록.
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0]-i2[0];
        });

        List<int[]> ans = new ArrayList<>();

        // state 배열에 출발,도착 상태 저장.
        Queue<State> states = new PriorityQueue<>();

        for(int i=0; i<intervals.length; i++) {

            states.offer(new State(intervals[i][0], 's'));
            states.offer(new State(intervals[i][1], 'e'));
        }

        int start = 0;
        int end = 0;
        int sCnt=0, eCnt=0;
        while (!states.isEmpty()) {
            
            State s = states.poll(); // 가장 작은 위치부터 하나씩 뺌.

            if(s.state == 's') { 
                if(sCnt == 0) { // 가장 첫 시작일 때
                    start = s.t; // overlap에 포함되어야 하므로, start로 지정
                }

                sCnt++;
            } else if(s.state == 'e') {
                
                eCnt++; // 먼저 증가
                if(sCnt == eCnt) { // 카운트 개수가 동일하면, 하나의 쌍 완성.
                    end = s.t;
                    ans.add(new int[]{start, end}); // 리스트에 쌍 추가
                    sCnt=0; // 개수 초기화
                    eCnt=0;

                }
            }

        }

        return ans.toArray(new int[0][]);
    }
}
```