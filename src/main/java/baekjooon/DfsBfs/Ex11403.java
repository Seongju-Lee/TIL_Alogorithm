import java.util.*;
import java.io.*;

class Ex11403{

    static boolean[] visited;
    static void dfs(ArrayList<Integer>[] list, int v) {

        int size = list[v].size();

        for (int i=0; i<size; i++) {
            int nv = list[v].get(i);
            if(!visited[nv]) {
                visited[nv] = true;
                dfs(list, nv);
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n];


        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                int val = Integer.parseInt(st.nextToken());
                if(val == 1) {
                    list[i].add(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            visited = new boolean[n];
            dfs(list, i);

            for(int j=0; j<n; j++) {
                if(visited[j]) {
                    sb.append(1 + " ");
                }else {
                    sb.append(0 + " ");
                }
            }
            sb.append('\n');

        }

        System.out.println(sb);



    }
}