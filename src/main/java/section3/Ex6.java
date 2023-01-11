package section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex6 {

    public void solution(int n, int k, int[] intArr){

        // k만큼 0을 1로 치환할 수 있음.


        int tmp = 0, tmp2 =1;
        int li=0, ri=0, last = 0;
        int zeroCnt = 0, cnt = 0, maxCnt = 0;
//        int[] zeroArr = new int[n];

        ArrayList zeroArr = new ArrayList(n);

        int init = 0;
        while(init != n){
            zeroArr.add(0);
            init++;
        }

        while(ri != intArr.length){


            if((intArr[ri] == 0) && zeroCnt != k+1){
                zeroCnt++;

                if(zeroCnt == k){
                    tmp = ri;
                } else if (zeroCnt == k+1) {

//                    ri--;
                    cnt = ((ri-1) - li) + 1;

                    if(maxCnt < cnt) maxCnt = cnt;

//                    System.out.println("li: " + li + ", ri: " + ri + ", cnt: " + cnt);

                }

            }


            if(zeroCnt == k+1){
                if(intArr[li] == 0){
                    zeroCnt -= 1;
                    ri++;
                }
                li += 1;

            }else ri++;

            // li 다음 인덱스 값이 0이라면 그곳(tmp)으로 이동하고,
            // li 다음 인덱스 값이 0이 아니라면 다음 인덱스로 이동한다.


//            ri++;

        }

        System.out.println("maxCount: " +  maxCnt);



    }
    public static void main(String[] args){

        Ex6 T = new Ex6();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] intArr = new int[n];

        for(int i=0; i<n; i++){
            intArr[i] = sc.nextInt();
        }
        T.solution(n, k, intArr);

    }
}
