package baekjooon.Map;

import java.util.*;
import java.io.*;

public class Ex17219 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            map.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<m; j++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            sb.append(map.get(s)).append('\n');
        }

        System.out.print(sb);
    }
}
