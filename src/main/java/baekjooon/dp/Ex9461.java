package baekjooon.dp;

import java.util.*;

class Ex9461 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            long[] dp = new long[n];

            if(n <= 6){
                dp = new long[6];
            }
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            dp[4] = 2;
            dp[5] = 3;

            for(int j=6; j<n; j++) {
                dp[j] = dp[j-1] + dp[j-5];
            }

            System.out.println(Arrays.toString(dp));
            sb.append(dp[n - 1]).append('\n');
        }
        System.out.println(sb);




    }
}