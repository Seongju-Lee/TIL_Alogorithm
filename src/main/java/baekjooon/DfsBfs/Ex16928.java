package baekjooon.DfsBfs;
import java.util.*;
import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex16928 {




    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladderMap = new TreeMap<>();
        Map<Integer, Integer> snakeMap = new TreeMap<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ladderMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            snakeMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int answer=0;
        boolean flag=true;
        boolean[] visited = new boolean[101];
        visited[1] = true;

        while(flag) {

            int qSize = q.size();

            for(int i=0; i<qSize; i++) {


                int val = q.poll();

                for(int j=1; j<=6; j++) {

                    int tmp = val+j;
                    if(ladderMap.keySet().contains(tmp)) {
                        tmp = (int) ladderMap.get(tmp);
                    } else if(snakeMap.keySet().contains(tmp)) {
                        tmp = (int) snakeMap.get(tmp);
                    }

                    if(tmp == 100) {
                        flag = false;
                        break;
                    }
                    if(!visited[tmp]){
                        q.offer(tmp);
                        visited[tmp] = true;
                    }
                }

                if(!flag) break;

            }

            answer+=1;

        }


        System.out.println("answer = " + answer);
    }

}
