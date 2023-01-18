package section7;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {

    static int[] arr;

    int solution(int n){

        // 1 1 2 3 5 8
        if(arr[n] > 0) return arr[n];

        if(n == 1) return arr[n]=1;
        else if (n == 2) return arr[n]= 1;
        else {
            int k = solution(n-2)+ solution(n-1);
            arr[n] = k;
            return k;
        }

    }

    public static void main(String[] args){

        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n+1];
//        for(int i=0)
        System.out.println(T.solution(n));

        System.out.println(Arrays.toString(arr));
    }
}
