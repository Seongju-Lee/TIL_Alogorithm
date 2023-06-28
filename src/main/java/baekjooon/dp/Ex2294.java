package baekjooon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2294 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[k + 1];
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {

                if (i == coin) {
                    dp[i] = 1;
                    continue;
                }

                if(dp[i] != 0 && dp[i-coin] != 0){
                    dp[i] = Math.min(dp[i], dp[i - coin]+1);
                }else if (dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                }

            }

        }

        if(dp[k] == 0) System.out.println(-1);
        else System.out.println(dp[k]);

    }
}
