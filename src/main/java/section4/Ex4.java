package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Ex4 {

    public void solution(String s, String t){

        /**
         * 아나그램: 한 문자열의 조합과 다른 문자열의 조합이 일치한 것.
         * 즉, 각 문자의 개수가 모두 동일하면 아나그램이라고 함.
         */
        int li=0, ri=0;
        char[] sArr = s.toCharArray();
        int n = t.length();
        int cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        HashMap<Character, Integer> inputMap = new HashMap<>();
        for(char c : t.toCharArray()){
            inputMap.put(c, inputMap.getOrDefault(c, 0)+ 1);
        }

        while (ri < s.length()){

            map.put(sArr[ri], map.getOrDefault(sArr[ri], 0)+1);

            if((ri-li+1)%n == 0){

                if(map.equals(inputMap)){
                    cnt++;

                }

                if(map.containsKey(sArr[ri-n+1])){
                    if(map.get(sArr[ri-n+1]) == 1) map.remove(sArr[ri-n+1]);
                    else map.put(sArr[ri-n+1], map.get(sArr[ri-n+1]) -1);

                }
                li++;


            }
            ri++;


        }

        System.out.println(cnt);

    }
    public static void main(String[] args) throws IOException {

        Ex4 T = new Ex4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputS = br.readLine();
        String inputT = br.readLine();

        T.solution(inputS, inputT);

    }
}
