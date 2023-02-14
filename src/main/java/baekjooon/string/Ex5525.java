package baekjooon.string;
import java.io.*;

class Ex5525 {

    // 문자열 순차 탐색 진행
    void solution(String s, int len, int n) {

        int cnt = 0;  /* 문자열 "IOI"가 연속하여 얼마나 나오는 지 확인.*/
        int answer = 0; /* cnt 와 n이 동일할 때, 카운트 증가. */


        for(int i=0; i<(len-2); i++) {

            // "IOI" 탐색.
            if(s.charAt(i) == 'I' && s.charAt(i+1)=='O' && s.charAt(i+2)=='I') {

                cnt+=1; // 카운트 증가.
                i += 1; // 두 칸 뒤로 이동

            } else {
                cnt = 0; // "IOI"라는 문자 교대가 끊긴 순간에 cnt 초기화.
            }


            if(cnt == n) {
                answer += 1;
                cnt -= 1; // cnt를 초기화 하지 않는 이유는 맨 앞에서 카운트 한 "IOI"만 카운트에서 제거해야 하기 때문.
            }

        }

        System.out.println(answer);

    }

    public static void main(String[] args) throws IOException {

        Ex5525 main = new Ex5525();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sLen = Integer.parseInt(br.readLine());
        String s = br.readLine();

        main.solution(s, sLen, n);
    }

}