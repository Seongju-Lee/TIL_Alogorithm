package baekjooon.Recursion;

import java.io.BufferedReader;
import java.util.Scanner;

public class Ex2798 {

    private static void rec(int[] cards, int[] ans, int sum, int idx,  int cnt, int m, int n) {

        if (cnt == 3) {

            if(Math.abs(ans[0]-m) > Math.abs(sum-m) && sum <= m) {
                ans[0] = sum;
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            rec(cards, ans, sum + cards[i], i+1, cnt + 1, m, n);

        }
                
        
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int[] ans = new int[1];

        rec(cards, ans, 0, 0,0, m, n);

        System.out.println(ans[0]);
    }
}
