package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6 {

    public boolean isPrime(int n){

        for(int i=2; i<n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public void solution(int[] intArr){

        for(int i: intArr){
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            sb.reverse();
            int num = Integer.valueOf(sb.toString());

            if(isPrime(num) && num != 1) System.out.print(num + " ");

        }


    }
    public static void main(String args[]){

        Ex6 T = new Ex6();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] intArr = new int[n];
        for(int i=0; i<n; i++){

            intArr[i] = sc.nextInt();

        }

        T.solution(intArr);
    }
}
