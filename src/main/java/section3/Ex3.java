package section3;

import java.util.*;

public class Ex3 {

    public void solution(int n, int k, int[] inputArr){

        System.out.println(Arrays.toString(inputArr));

        int sum = 0;

        for(int i=0; i<k; i++){
            sum += inputArr[i];
        }
        int answer = sum;
        // 연속된 k의 합의 최댓값.
        for(int i=k; i<n; i++){

            // 슬라이싱 윈도우 알고리즘 체크
            sum += (inputArr[i]);
            sum -= inputArr[i-k];
            System.out.println(sum);

            if(sum > answer)
                answer = sum;


        }

        System.out.println(answer);
    }
    public static void main(String[] args){

        Ex3 T = new Ex3();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] inputArr = new int[n];
        for(int i=0; i<n; i++)
            inputArr[i] = sc.nextInt();

        T.solution(n, k, inputArr);
    }
}
