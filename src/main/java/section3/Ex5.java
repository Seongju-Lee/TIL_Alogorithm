package section3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {




    public void solution(int n){


        // 1부터 n까지 배열을 생성.
        // ri를 하나씩 이동하면서 sum에 값 하나씩 누적.
        // sum이 >= n이면 ri 멈추고,
        // li를 하나씩 이동하면서 sum에서 값 하나씩 뺌.
        // sum < n이면 li 멈추고 다시 ri 이동
        // 한번 사이클 돌때마다, sum == n인지 확인.

        int[] intArr = new int[n];
        for(int i=0; i<n; i++){
            intArr[i] = i+1;
        }

        int sum = 0;
        int cnt = 0;
        int li=0, ri = 0;


        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15


        while (ri != intArr.length){

            if(sum >= n){
                sum -= intArr[li++];

            }else{
                sum += intArr[ri++];
            }

            if(sum == n){
//                System.out.println(li + ", " + ri);
                cnt++;
            }

        }
        System.out.print(cnt);

    }
    public static void main(String[] args){

        Ex5 T = new Ex5();
        Scanner sc = new Scanner(System.in);

        T.solution(sc.nextInt());

    }
}
