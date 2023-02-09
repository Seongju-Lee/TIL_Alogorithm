package baekjooon.etc;

import java.util.*;

class Ex1929 {


    void solution(int m , int n ) {

        int[] primeArr = new int[n+1];
        primeArr[0] = primeArr[1] = 1;

        for (int i = 2; i <= Math.sqrt(n); i++) { // 등호 필수

            if(primeArr[i] == 1) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                primeArr[j] = 1;
            }

        }

        for (int i=m; i<=n; i++) {
            if(primeArr[i] != 1) System.out.println(i);
        }


    }


    public static void main(String[] args) {

        Ex1929 main = new Ex1929();
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        main.solution(m, n);

    }

}
