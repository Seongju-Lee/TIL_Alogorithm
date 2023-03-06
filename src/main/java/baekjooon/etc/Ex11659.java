package baekjooon.etc;
import java.util.*;
import java.io.*;

public class Ex11659 {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            arr[0] = Integer.parseInt(st.nextToken());
            for(int i=1; i<n; i++) {
                arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken())-1;
                int k = Integer.parseInt(st.nextToken())-1;

                int tmp=0;
                if(s == 0) {
                    tmp = arr[k];
                } else {
                    tmp = arr[k] - arr[s-1];
                }

                sb.append(tmp).append('\n');
            }

            System.out.print(sb);

        }
}
