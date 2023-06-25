package baekjooon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1463 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 2];
        Arrays.fill(dp, n-1);
        dp[n] = 0;

        for (int i = n; i >= 1; i--) {

            dp[i] = Math.min(dp[i], dp[i + 1] + 1);

            if(i%3 == 0) {
                dp[i / 3] = Math.min(dp[i] + 1, dp[i / 3]);
            }
            if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i] + 1, dp[i / 2]);
            }

        }

        System.out.println(dp[1]);
    }
}
