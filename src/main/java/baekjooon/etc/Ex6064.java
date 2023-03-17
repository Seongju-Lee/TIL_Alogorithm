package baekjooon.etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex6064 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<t; i++) {

            st =  new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            int year = x;
            boolean isNot = true;
//            System.out.println("ny = " + ny);
            while (year <= m*n) {

                int ny = (year%n);

//                System.out.println("ny = " + ny);
                if(ny == 0) {
                    ny = n;
                }
                if(ny == y) {
                    isNot = false;
                    break;
                }

                year += m;
            }
//
//            System.out.println();

            if(isNot){
                sb.append(-1);
            } else {
                sb.append(year);
            }
            sb.append('\n');

        }

        System.out.print(sb);
    }
}
