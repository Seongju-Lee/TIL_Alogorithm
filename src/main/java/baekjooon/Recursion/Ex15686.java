package baekjooon.Recursion;

import java.util.*;

public class Ex15686 {


    /*
        n: board 크기
        m: 뽑아야 할 치킨집 개수
        chickenHouses: 치킨집 좌표들
        board: 보드
        ans: 답킨
        visited: 방문한 치킨집
     */
    private static void rec(int m, List<int[]> chickenHouses, List<int[]> houses, int[] ans, boolean[] visited, int cnt, int idx) {

        if (cnt == m) {
            // 정해진 치킨집 리스트 들고,
            // 최소 거리 구하러 이동

            int disSum = 0;
            for (int[] house : houses) {

                int minDis = Integer.MAX_VALUE;

                for (int i = 0; i < chickenHouses.size(); i++) {

                    if(visited[i]) {

                        int dis = (Math.abs(chickenHouses.get(i)[0] - house[0]) + Math.abs(chickenHouses.get(i)[1] - house[1]));
                        minDis = Math.min(minDis, dis);
                    }
                }

                disSum += minDis;
            }


            ans[0] = Math.min(disSum, ans[0]);
            return;
        }


        for (int i = idx; i < chickenHouses.size(); i++) {

            if(!visited[i]) {

                visited[i] = true;
                rec(m, chickenHouses, houses, ans, visited, cnt+1, i+1);
                visited[i] = false;
            }
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<int[]> chickenHouses = new ArrayList<>();
        List<int[]> houses = new ArrayList<>();

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();

                if(board[i][j] == 2) {
                    chickenHouses.add(new int[]{i, j});
                } else if(board[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
            }
        }

        int[] ans = new int[1];
        boolean[] visited = new boolean[chickenHouses.size()];
        ans[0] = Integer.MAX_VALUE;


        rec(m, chickenHouses, houses , ans, visited, 0, 0);

        System.out.println(ans[0]);
    }
}
