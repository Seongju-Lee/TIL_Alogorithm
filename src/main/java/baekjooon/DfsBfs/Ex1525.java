package baekjooon.DfsBfs;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

class Ex1525 {

    public static void main(String[] args) throws IOException {

        int answer = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[3][3];

        StringBuilder sb = new StringBuilder();

        // 0의 좌표를 넣을 q -> 좌표로 하게되면 계속 9번 반복 돌면서 String을 생성해줘야 함.
        // q에 String을 넣고, String에서 0의 index를 찾는다.
        Queue<String> q = new LinkedList<>();
        // 0123456789까지 가는데 횟수를 저장하기 위한 map
        Map<String, Integer> map = new HashMap<>();

        // 데이터 입력
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                sb.append(board[i][j]);
            }
        }
        q.offer(sb.toString());
        map.put(sb.toString(), 0);

        // 탐색 시작
        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};
        int cnt=0;
        Loop: while(!q.isEmpty()) {

            cnt++;

            int qSize = q.size();

            for(int i=0; i<qSize; i++) {

                String current = q.poll().toString();
                int zeroIdx = current.indexOf('0');
                int cx = (zeroIdx/3);
                int cy = (zeroIdx%3);

                for(int j=0; j<4; j++) {
                    int nx = cx+xi[j];
                    int ny = cy+yi[j];

                    if(nx >= 0 && ny >= 0 && nx<3 && ny<3) {
                        int changeIdx = nx * 3 + ny;
                        StringBuilder next = new StringBuilder(current);
                        next.setCharAt(zeroIdx, current.charAt(changeIdx));
                        next.setCharAt(changeIdx, '0');
                        System.out.println(next + ", " +cnt);
                        if(map.getOrDefault(next.toString(), -1) == -1) {
                            map.put(next.toString(), cnt);
                            q.offer(next.toString());

                            if(next.toString().equals("123456780"))
                                break Loop;
                        }

                    }

                }


            }


        }

        System.out.print(map.getOrDefault("123456780", -1));

    }

}