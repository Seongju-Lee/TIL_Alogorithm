package baekjooon.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex14888 {


    // arr: 피연산자
    // operators: 연산자 목록
    // n: 연산자 개수
    // visited: list 중 사용한 연산자 매핑
    // cnt: 사용한 연산자 개수(연산자를 다 사용하면 연산이 완료되었다는 의미)
    // ans[0]: 최댓값, ans[1]: 최솟값
    // res: 현재 연산 결과(초깃값은 가장 첫번째 값)
    private static void rec(int[] arr, List<Character> operators, int n, boolean[] visited, int cnt, int[] ans, int res, int idx) {


        if (cnt == n) {
            ans[0] = Math.max(ans[0], res);
            ans[1] = Math.min(ans[1], res);
            return;
        }

        for (int i = 0; i < n; i++) {

            if(!visited[i]) {

                visited[i] = true;


                // 연산자 종류에 따른 연산 후, 재귀
                switch (operators.get(i)) {

                    case '+':

                        rec(arr, operators, n, visited, cnt + 1, ans, res + arr[idx], idx+1);
                        break;

                    case '-':

                        rec(arr, operators, n, visited, cnt + 1, ans, res - arr[idx], idx+1);
                        break;

                    case '*':
                        rec(arr, operators, n, visited, cnt + 1, ans, res * arr[idx], idx+1);
                        break;

                    case '/':

                        if(res < 0 && arr[idx]>0) {
                            int tmp = -1 * res;
                            tmp /= arr[idx];
                            tmp *= -1;
                            rec(arr, operators, n, visited, cnt + 1, ans, tmp, idx+1);

                        } else {
                            rec(arr, operators, n, visited, cnt + 1, ans, res / arr[idx], idx+1);
                        }

                        break;


                }


                visited[i] = false;
            }
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] tmp = new int[n-1];
        List<Character> operator = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int cnt = sc.nextInt();
            char c = ' ';

            if(i == 0) c = '+';
            else if(i == 1) c = '-';
            else if(i == 2) c = '*';
            else c = '/';

            for (int j = 0; j < cnt; j++) {
                operator.add(c);
            }
        }


        System.out.println("operator = " + operator);
        int[] ans = new int[2];
        ans[0] = Integer.MIN_VALUE;
        ans[1] = Integer.MAX_VALUE;
        boolean[] visited = new boolean[operator.size()];
        rec(arr, operator, operator.size(), visited, 0, ans, arr[0], 1);

        System.out.println(ans[0]);
        System.out.println(ans[1]);

    }
}
