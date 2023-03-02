package baekjooon.Greedy;

import java.util.*;

public class Ex11399 {

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int tmp = 0;
        for (int i=0; i<arr.length; i++) {
            tmp += arr[i];
            answer += tmp;
        }

        System.out.println(answer);
    }
}
