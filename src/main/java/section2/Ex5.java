package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {

    // 에라토스테네스 체 알고리즘(소수 구하기.)
    // 제곱근을 이용하면 for문의 개수를 줄일 수 있다.
    // 하지만, 개수를 구하기 위해서 하나씩 적용하는 것이 더 빠름.
    public void solution(int n){

        int[] primeArr = new int[n];
        int cnt = 0;

        if(n>1)
            primeArr[0] = primeArr[1] = 1;


        System.out.println(Math.sqrt(n));

        for(int i=2; i<n; i++){
            if(primeArr[i] == 0){
                cnt++;
                for(int j=i; j<n; j+=i){
                    if(j != i)
                        primeArr[j] = 1;
                }
            }
        }

        for(int i=0; i<primeArr.length; i++){
            if(primeArr[i] == 0)
                System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(Arrays.toString(primeArr));
        System.out.println(cnt);


    }
    public static void main(String args[]){

        Ex5 T = new Ex5();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}
