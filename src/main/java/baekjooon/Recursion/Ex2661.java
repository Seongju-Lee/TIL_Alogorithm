package baekjooon.Recursion;

import java.util.Scanner;

public class Ex2661 {

    private static void rec(String[] ans, boolean[] check, StringBuilder sb, int n) {

        if (sb.length() == n) {
            ans[0] = sb.toString();
            check[0] = true;
            return;
        }


        for (int i = 1; i <= 3; i++) {

            sb.append(i);
            boolean flag = true;

            if(sb.length() == 0 || sb.length() == 1) rec(ans, check, sb, n);

            int comparisonLen = sb.length()/2; // 비교할 suffix와 prefix 길이
            for (int len = comparisonLen; len > 0; len--) {

                String suffix = sb.substring(sb.length() - len, sb.length());
                String prefix = sb.substring(sb.length() - (2 * len), sb.length() - len);


                if (suffix.equals(prefix)) {
                    flag = false;
                    break;
                }
            }

            if(flag) rec(ans, check, sb, n);


            if(check[0]) return;
            sb.deleteCharAt(sb.length()-1); // 연속되어 있으면 삭제
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        String[] ans = new String[1];
        boolean[] check = new boolean[1];

//        for (int i = 1; i <=3 ; i++) {
//
//            sb.append(i);
//            sb.deleteCharAt(sb.length() - 1);
//        }
        rec(ans, check, sb, n);

        System.out.println("ans = " + ans[0]);

    }
}
