package baekjooon.dp;

import java.util.Scanner;

public class Ex2293 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[k+1];
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        for (int coin : coins) {

            for (int i = coin; i <= k; i++) {

                dp[i] += dp[i-coin];
                if(i == coin) {
                    dp[i] += 1;
                }
            }

        }

        System.out.println(dp[k]);


    }
}
