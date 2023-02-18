package baekjooon.etc;

import java.util.Scanner;

public class Ex1676 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int cnt = 0;

        // 5로 소인수분해
        while (n >= 5) {
            cnt += (n/5);
            n /= 5;
        }

        System.out.print(cnt);
    }
}
