package baekjooon.etc;

import java.util.*;

public class Ex1629 {

    static long dfs(long a, int b, long c) {

        if(b == 1)
            return a%c;
        else {

            long x = dfs(a, b/2, c);
            long val = (x*x)%c;

            if(b%2 == 0) {
                return val;
            } else {
                return (val*a)%c;
            }
        }



    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        long answer = dfs(A, B, C);
        System.out.println(answer);
    }
}
