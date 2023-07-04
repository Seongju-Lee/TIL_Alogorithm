package baekjooon.string;

import java.util.*;

public class Ex2179 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        int[] ansIdx = new int[2];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = (i+1); j < n; j++) {

                if(arr[i].equals(arr[j])) continue;

                int l = Math.min(arr[i].length(), arr[j].length());
                int len = 0;
                for (int k = 0; k < l; k++) {

                    if (arr[i].charAt(k) != arr[j].charAt(k)) {
                        break;
                    }
                    len++;
                }

                if (maxLen < len) { // 정답 정보 변경
                    ansIdx[0] = i;
                    ansIdx[1] = j;
                    maxLen = len;
                }

            }
        }

        if (ansIdx[0] == 0 && ansIdx[1] == 0) {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
        } else {
            System.out.println(arr[ansIdx[0]]);
            System.out.println(arr[ansIdx[1]]);
        }

    }
}
