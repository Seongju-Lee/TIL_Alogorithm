package section8;

import java.util.*;

public class Ex2 {

    static int N, C ;
    static int maxValue;
    void solution(int idx, int sum, Integer[] arr) {

        if(sum >= C) return;
        if(idx == (N)) {
            if(maxValue < sum) maxValue = sum;
        }
        else {

            solution((idx+1), (sum + arr[idx]), arr);
            solution((idx+1), sum, arr);

        }



    }
    public static void main(String[] args) {

        Ex2 T = new Ex2();
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        T.solution(0, 0, arr);

        System.out.println(maxValue);
    }
}
