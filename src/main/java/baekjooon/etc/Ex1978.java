package baekjooon.etc;
import java.util.*;

class Ex1978 {

    static int[] primeArr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        primeArr = new int[1001];
        primeArr[0] = primeArr[1] = 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {

                if(arr[i]%j == 0) arr[i] = 1;
            }

        }

        int cnt=0;
        for (int i : arr) {
            if(primeArr[i] == 0) cnt++;
        }

        System.out.println(cnt);
    }
}
