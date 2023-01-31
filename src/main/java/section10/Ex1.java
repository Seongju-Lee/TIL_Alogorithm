package section10;

import java.util.Scanner;

public class Ex1 {

    void solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = dp[1] + 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[dp.length-1]);
    }


    public static void main(String[] args) {
        Ex1 T = new Ex1();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        T.solution(n);
    }
}