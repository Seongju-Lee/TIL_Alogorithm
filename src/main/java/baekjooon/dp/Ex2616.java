package baekjooon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2616 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = (sc.nextInt() + sum[i - 1]);
        }

        int max = sc.nextInt();
        int[][] dp = new int[4][n+1];

        // 소형 기관차 1대 ~ 3대까지 dp
        for (int i = 1; i <= 3; i++) {
            for (int j = i*max; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][(j - max)] + (sum[j] - sum[j - max]));
            }
        }

        System.out.println(dp[3][n]);
    }
}
