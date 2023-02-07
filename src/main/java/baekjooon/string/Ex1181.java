package baekjooon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex1181 {

    void solution(String[] arr, int n) {


        Arrays.sort(arr, (s1, s2) -> {

            if(s1.length() == s2.length()) return s1.compareTo(s2);
            else return s1.length() - s2.length();
        });

        System.out.println(arr[0]);
        for(int i=1; i<n; i++) {
            if(!arr[i].equals(arr[i-1]))
                System.out.println(arr[i]);
        }

    }

    public static void main(String[] args) throws IOException {

        Ex1181 main = new Ex1181();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];


        for(int i=0; i<n; i++) {

            arr[i] = br.readLine();
        }

        main.solution(arr, n);
    }
}
