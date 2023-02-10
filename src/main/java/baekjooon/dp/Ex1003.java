package baekjooon.dp;
import java.util.*;
import java.io.*;

public class Ex1003 {

    static int[] zeroCnt, oneCnt, checked; // (인덱스 값)번쨰 피보나치 수가 호출 될 때, 0과 1 이 각각 호출되는 횟수 저장.

    int fibonacci(int n) {

        if(checked[n] != 0) {
            System.out.println(Arrays.toString(checked));
            return checked[n];
        }

        if(n == 0) {

            return 0;

        } else if(n == 1) {
            return 1;

        } else {

            checked[n] = fibonacci(n-2) + fibonacci(n-1);
            zeroCnt[n] = zeroCnt[n-2] + zeroCnt[n-1];
            oneCnt[n] = oneCnt[n-2] + oneCnt[n-1];
            return checked[n];

        }




    }

    public static void main(String[] args) throws IOException {

        Ex1003 main = new Ex1003();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();


        for(int i=0; i<t; i++) {

            checked = new int[41];
            zeroCnt = new int[41];
            oneCnt = new int[41];

            zeroCnt[0] = 1;
            zeroCnt[1] = 0;
            oneCnt[0] = 0;
            oneCnt[1] = 1;

            int n = Integer.parseInt(br.readLine());

            // System.out.println( "피보나치 값: " + main.fibonacci(n));
            main.fibonacci(n);
            sb.append(zeroCnt[n] + " " + oneCnt[n]).append('\n');

        }
        System.out.print(sb);

    }
}
