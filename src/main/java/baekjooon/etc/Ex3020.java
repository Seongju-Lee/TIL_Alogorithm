package baekjooon.etc;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3020 {

    private static void solution(int[] upArr , int[] downArr, int n, int h) {

        // downArr, upArr 각각을 크기를 기준으로 내림차순하면서 누적 합 (더 큰것의 개수만큼)
        for (int i = (h-1); i >= 1 ; i--) {
            upArr[i] += upArr[i + 1];
            downArr[i] += downArr[i + 1];
        }

        // 1 ~ h까지 돌면서, downArr과 upArr 충돌하는 부분을 찾는다
        // downArr[i]와 upArr[h-i]랑 더하면 됨
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            int broken = upArr[h - i+1] + downArr[i];

            if (min == broken) {
                cnt++;
            }
            else if(min > broken) {
                cnt = 1;
                min = broken;
            }
        }

        System.out.println(min + " " + cnt);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] downArr = new int[h+1];
        int[] upArr = new int[h+1];

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                downArr[sc.nextInt()]++;
            } else {
                upArr[sc.nextInt()]++;
            }
        }


        solution(upArr, downArr, n, h);


    }
}
