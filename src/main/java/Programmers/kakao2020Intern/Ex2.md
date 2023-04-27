[//]: # (# Intuition)
<!-- Describe your first thoughts on how to solve this problem. -->

# 2020 Kakao Internship
___
경주로 건설

## Approach
<!-- Describe your approach to solving the problem. -->
현재 이동 방향의 상-하-좌-우 탐색  
탐색 경우의 수를 줄이기 위해 이미 방문한 곳을 체크하면 문제발생.  
-> 경로 A와 B가 있다고 가정할 때, 특정 지점(x,y)에 A가 먼저 도착한 후 B가 도착했는데 B의 비용이 더 저렴할 가능성 있음.  
따라서 아래와 같이 진행.   
1. A가 방문했을 때, A의 비용을 해당 위치(x, y)에 저장.
2. B가 (x, y)에 도달 했을 때, 그 위치에서의 A의 비용과 비교.
3. B가 더 저렴할 시, (x, y)로 이동함 / A가 더 저렴했다면, B는 (x, y)로 이동 안함.     

3-1. 하지만, 여기서 문제는 B와 A가 다른 방향으로 (x, y)에 들어왔다면 B는 비용에 상관없이 (x, y)로 이동 가능해야 한다.  
-> 방향에 따라 (0, 0) 부터 (x, y)까지 온 코너의 개수 & (x, y)부터 목적지까지 가는데 있는 코너의 개수 등이 다르기 때문.



[//]: # (## Complexity)

[//]: # (- Time complexity: O&#40;4^N&#41;  )

<!-- Add your time complexity here, e.g. $$O(n)$$ -->

[//]: # (- Space complexity:)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
import java.util.*;

class Point {
    public int x;
    public int y;
    public int corner;
    public int dir; // 방향-> 0: 상, 1: 우, 2: 하, 3: 좌
    
    Point(int x, int y, int c, int d) {
        this.x = x;
        this.y = y;
        corner = c;
        dir = d;
    }
}

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        
        int[][][] newBoard = new int[4][n][n];
        // board[x][y]에는 현재 위치(x,y)의 최소비용을 저장한다.
        for(int z=0; z<4; z++) {
            for(int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if(board[i][j] != 1) {
                        newBoard[z][i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        newBoard[0][0][0] = 0; // 명시적으로 비용 삽입.
        newBoard[1][0][0] = 0; // 명시적으로 비용 삽입.
        newBoard[2][0][0] = 0; // 명시적으로 비용 삽입.
        newBoard[3][0][0] = 0; // 명시적으로 비용 삽입.
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0, 1));
        q.offer(new Point(0, 0, 0, 2));
        
        // 네 방향 탐색용 배열
        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};
        
        int straight = 0;
        while (!q.isEmpty()) {
            
            int size = q.size(); // 동일 거리 이동.(다른 방향)
            
            for(int s=0; s<size; s++) {
                
                Point p = q.poll();
                
                for(int i=0; i<4; i++) { // 현재 위치인 p.x, p.y에서 네 방향 탐색.
                    
                    int nx = p.x + xi[i];
                    int ny = p.y + yi[i];
                    
                    
                    // 외부, 벽은 다음 탐색위치로 선정X
                    if(nx >= 0 && ny>=0 && nx<n && ny<n && newBoard[i][nx][ny] != 1) {

                        // 다음 위치에서의 비용을 계산.
                        int nPrice = 0;
                        int nextCorner = p.corner;
                        
                        if(i==0 || i==2) { // 탐색 위치가 위, 아래인 경우

                            // 현재 방향이 우, 좌라면 다음 위치에서 코너가 하나 증가
                            if(p.dir==1 || p.dir==3) { 
                                nextCorner++;
                                nPrice += ((nextCorner)*500);
                            } else {
                                nPrice += (nextCorner*500); // 일정한 방향이면 코너X
                            }
                        } else if(i==1 || i==3) { // 탐색위치 : 우 or 좌

                            if(p.dir==0 || p.dir==2) {
                                nextCorner++;
                                nPrice += ((nextCorner)*500);
                            } else {
                                nPrice += (nextCorner*500); // 일정한 방향이면 코너X
                            }

                        }
                    
                        nPrice += (straight+1)*100; // 직진거리는 무조건 증가.
                    
                        // 위에서 계산한 다음위치의 비용이 이미 어떤 경로에 의해 더 적다면 반영X
                        if(newBoard[i][nx][ny] >= nPrice) {

                            newBoard[i][nx][ny] = nPrice;
                            q.offer(new Point(nx, ny, nextCorner, i)); // 변경된 코너 수, 방향 q에 삽입.
                            
                            if(nx==(n-1) && ny==(n-1)) answer=Math.min(answer, nPrice); // 도착지에 최소비용 반영.
                        }
                    
                    }
                    
                }
                
            }
                
            // 직진 비용 추가.
            straight++;
        }
        return answer;
    }
}
```