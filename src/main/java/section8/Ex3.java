package section8;

import java.util.*;


public class Ex3 {

    static int N,M;
    static int maxValue;

    void solution(int idx, int scoreSum, int timeSum, int[] scores, int[] time) {

        if((timeSum > M)) return;

        // score을 기준으로 합을 진행한다.
        if(idx == N) { //N: 문제의 개수
            if(maxValue < scoreSum) maxValue = scoreSum;
        }else {

            solution(idx+1, scoreSum+scores[idx], timeSum+time[idx], scores, time);
            solution(idx+1, scoreSum, timeSum, scores, time);

        }


    }
    public static void main(String[] args) {

        Ex3 T = new Ex3();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 문제의 개수
        M = sc.nextInt(); // 제한시간

        int[] scores = new int[N];
        int[] time = new int[N];

        for (int i=0; i<N; i++) {
            scores[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        T.solution(0, 0, 0,scores, time);

        System.out.println(maxValue);
    }
}
