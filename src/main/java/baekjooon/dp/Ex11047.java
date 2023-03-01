package baekjooon.dp;

import java.util.*;
import java.io.*;

class Ex11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count=0;
        for(int j=(coins.length-1); j>=0; j--) {
            int coin = coins[j];
            if(coin <= k) {
                count += (k/coin);
                k = (k%coin);
            }

            if(k==0) break;
        }
        System.out.print(count);
    }
}