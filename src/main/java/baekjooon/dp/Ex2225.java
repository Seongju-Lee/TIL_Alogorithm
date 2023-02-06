package baekjooon.dp;

import java.util.*;
import java.io.*;

class Ex2225 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void solution(int n, int k, long[][] dp) throws IOException {


        // n: 구할 정수값
        // k: 개수

        for(int i=2; i<=k; i++) {
            for (int j=0; j<=n; j++) {

                for(int t=0; t<=j; t++){
                    dp[i][j] += ((dp[i-1][t])%1_000_000_000);

                }
            }
        }
        bw.write(String.valueOf(dp[k][n] % 1_000_000_000));


    }

    public static void main(String[] args) throws IOException {

        Ex2225 m = new Ex2225();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[k+1][n+1];
        Arrays.fill(dp[1], 1);

        m.solution(n, k, dp);

        br.close();
        bw.flush();
        br.close();


    }
}