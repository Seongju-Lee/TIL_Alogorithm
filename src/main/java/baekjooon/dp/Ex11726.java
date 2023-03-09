package baekjooon.dp;
import java.util.*;

public class Ex11726 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        System.out.println("dp[n] = " + dp[n]);
        System.out.println("answer= " + dp[n]%10_007);
    }
}
