package baekjooon.DfsBfs;
import java.util.*;


public class Ex16236 {


    /**
     * eatList (PriorityQueue 로 선언)
     *
     * bfs를 통해 가장 가깝고 레벨이 작은 녀석을 찾음
     * 찾으면 eatList에 저장
     *
     * 동일 이동 거리 내, eatList size가 1이면,
     * 먹고, 이동거리 누적
     *
     * 동일 이동거리 내, eatList size가 크면(먹을게 많으면)
     * 가장 우선순위 높은 녀석을 먹음
     * 먹고, 이동거리 누적
     *
     * 먹고, 본인 레벨만큼 먹었다면 먹은횟수 초기화&레벨+1
     *
     * 먹은 자리는 0으로 변경
     *
     * 근데, eatList에 먹을게 많았더라도
     * 하나 먹었으면 초기화 하고, 그 자리에서 다시 bfs 진행
     * (레벨 업을 하거나 더 가까운 녀석이 있을 수 있음)
     *
     *
     */
    private static void bfs(int n, int[][] board, int[] sharkPoint, int[] ans) {


        // 1. 가장 높이 있는 애, 2. 가장 왼쪽에 있는 애
        Queue<int[]> eatList = new PriorityQueue<>((arr1, arr2) -> {

            if(arr1[0] == arr2[0]) return arr1[1] - arr2[1];
            else return arr1[0] - arr2[0];
        });

        int level = 2; // 상어 레벨
        int eatCnt = 0; // 먹이를 먹은 횟수
        int distance = 0; // 이동거리

        Queue<int[]> q = new LinkedList<>(); // bfs용 Queue
        q.offer(sharkPoint);


        boolean[][] visited = new boolean[n][n];

        while (!q.isEmpty()) {

            int size = q.size();

            int[] xi = {-1, 0, 1, 0};
            int[] yi = {0, 1, 0, -1};


            // 같은 거리를 이동
            for (int s = 0; s < size; s++) {

                int[] point = q.poll();

                for (int i = 0; i < 4; i++) {

                    int nx = point[0] + xi[i];
                    int ny = point[1] + yi[i];


                    // 지나갈 수 있는 조건
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] <= level && !visited[nx][ny]) {

                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        if(board[nx][ny] > 0 && board[nx][ny] < level) {
                            eatList.add(new int[]{nx, ny}); // 먹이 리스트에 추가
                        }

                    }

                }

            }

            distance++;

            // 먹을 수 있는 애가 있다면
            if (!eatList.isEmpty()) {
                int[] preyPosition = eatList.poll();

                eatCnt++;
                board[sharkPoint[0]][sharkPoint[1]] = 0;
                ans[0] += distance;


                distance = 0;

                sharkPoint = preyPosition;
                board[preyPosition[0]][preyPosition[1]] = 0;

                // 지금까지 정보 초기화
                visited = new boolean[n][n];
                q.clear();
                eatList.clear();
                q.offer(sharkPoint);

                // 레벨업 유무
                if (eatCnt == level) {
                    level++;
                    eatCnt = 0;
                }
            }



        }

    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] board = new int[n][n];
        int[] sharkPoint = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();

                board[i][j] = tmp;

                if (tmp == 9) {
                    sharkPoint[0] = i;
                    sharkPoint[1] = j;
                }


            }
        }


        int[] ans = new int[1];
        bfs(n, board, sharkPoint, ans);

        System.out.println("ans[0] = " + ans[0]);


    }
}