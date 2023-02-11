package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountingWords {

    public static void main(String[] args) throws IOException {

        int[] arr = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String upperS = s.toUpperCase();
        for(char c : upperS.toCharArray()) {
            int idx = c;
            idx -= 65;
            arr[idx] += 1;
        }


        int maxValue = 0;
        char c = '?';

        for(int i=0; i<26; i++) {

            if(maxValue < arr[i]) {
                maxValue = arr[i];
                c = (char) (i+65);

            } else if(maxValue == arr[i]) {
                c = '?';

            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(c);



    }
}
