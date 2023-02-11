package baekjooon.Recursion;

import java.io.*;
import java.util.*;

public class Ex1074 {

    static long x, y, answer;

    void solution(long size) {

        long halfSize = size/2;

        // 1사분면 : half*half만큼 더하고 재귀
        if( x < halfSize && y >= halfSize) {

            answer += halfSize*halfSize;
            y -= halfSize;
        }

        // 2 : 0더함
        else if(x < halfSize && y < halfSize) {
            answer += 0;

        }

        // 3 : half*half*2 만큼 더하고 재귀
        else if (x >= halfSize && y < halfSize) {
            answer += halfSize*halfSize*2;
            x -= halfSize;

        }

        // 4: half*half*3 만큼 더하고 재귀
        else {
            answer += halfSize*halfSize*3;
            x -= halfSize;
            y -= halfSize;

        }

        if(halfSize == 1) {
            return;
        }

        solution(halfSize);
    }

    public static void main(String[] args) throws IOException {

        // n: 2^n x 2^n 크기
        // x: 행, y: 열
        Ex1074 main = new Ex1074();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        long size = 1;
        for (int i = 0; i < n; i++) {
            size *= 2;
        }
        main.solution(size);

        System.out.print(answer);
    }
}
