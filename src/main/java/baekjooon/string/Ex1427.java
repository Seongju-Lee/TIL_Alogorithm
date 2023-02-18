package baekjooon.string;

import java.io.*;
import java.util.*;


public class Ex1427 {

    public static void main(String[] args) throws IOException {

        Ex1427 main = new Ex1427();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = (br.readLine()).toCharArray();

        Integer[] answer = new Integer[arr.length];
        for(int i=0; i<arr.length; i++) {

            answer[i] = (arr[i] - '0');
        }


//        Arrays.sort(answer, Collections.reverseOrder());
        Arrays.sort(answer, (i1, i2) -> { return i2 - i1;} );

        for(int i : answer) {
            sb.append(i);
        }
        System.out.print(sb);

    }
}
