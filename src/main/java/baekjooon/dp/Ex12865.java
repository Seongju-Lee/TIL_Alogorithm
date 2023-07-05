package baekjooon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex12865 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0}); // 0번 인덱스 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new int[]{w, v});
        }

        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                // 기본적으로 삽입
                if(list.get(i)[0] > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                // 조합(서로 다른 물건들의 조합)
                int weight = list.get(i)[0];
                int anotherWeight = j - weight;
                dp[i][j] = Math.max(dp[i-1][j], list.get(i)[1] + dp[i-1][anotherWeight]);
            }
        }

        // k보다 무게가 낮은 값 중, 최대 가치 탐색
        System.out.println(dp[n][k]);
    }
}
