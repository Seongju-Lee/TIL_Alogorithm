package section3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {

    public void solution(int n, int k, int[] inputArr){

        int li = 0, ri = 0;
        int sum = 0;
        int cnt = 0;
        // 합이 k여야 됨.
        // 1 2 1 3 1 1 1 2

        while(ri != n) {
            if (sum >= k) {
                sum -= inputArr[li];
                li++;

            } else {
                sum += inputArr[ri];
                ri++;
            }

            if(sum == k) cnt++;

        }


        System.out.println(cnt);
    }
    public static void main(String[] args){

        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] inputArr = new int[n];
        for(int i=0; i<n; i++)
            inputArr[i] = sc.nextInt();

        T.solution(n, k, inputArr);
    }
}
