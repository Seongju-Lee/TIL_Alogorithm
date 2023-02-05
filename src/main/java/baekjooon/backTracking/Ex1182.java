package baekjooon.backTracking;

import java.util.*;

class Ex1182 {

    static int n, s, answer;
    static int[] arr;


    void solution(int value, int depth){

        if((depth+1) == n ){
            if(value == s)
                answer++;
            else return;
        } else {

            solution(value+arr[depth+1], depth+1);
            solution(value, depth+1);

        }

    }

    public static void main(String[] args) {

        Ex1182 T = new Ex1182();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        T.solution(0, -1);

        if(s==0) System.out.print(answer-1);
        else System.out.print(answer);
    }
}