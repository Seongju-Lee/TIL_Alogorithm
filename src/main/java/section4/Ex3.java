package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex3 {


    /**
     * HashSet을 처음에 사용했으나, Time 초과가 너무 심함.
     * 이유를 생각해보니, set을 계속 비워주고 -> 채워서 개수 체크를 하는 과정에서
     * 개수가 많아질수록 반복량이 기하급수적으로 늘어남.
     *
    public void solution(int n , int k , int[] inputArr){

        int li = 0;
        HashSet<Integer> set = new HashSet<>();


        // li 부터 ri 까지 set에 저장.
        // set의 size를 int[]에 차례로 저장.

        while (li+k <= n){
//            set.clear();
            set.remove(inputArr[li]);
            set.add(inputArr[li]);

            for(int i = li; i<li+k; i++){
                set.add(inputArr[i]);
                if(inputArr[li-1] == inputArr[i]) continue;

            }

            li++;
            System.out.print(set.size() + " ");

        }

    }
     */


    public void solution2(int n, int k, int[] inputArr){

        /* li 0인 상태로 ri++ 진행.
           ri의 값을 map에 key로 추가하면서, value는 카운트+1 진행.
           ((ri - li) + 1)이 k가 되는 순간 정지.
//           answer.add를 통해 map의 키 개수 추가.

            (반복)
           다음은 현재 li인덱스의 값을 키로 가지는 value를 -1함. 만약 value-1이 0이면 map에서 엔트리 삭제
           li는 하나 증가.
           ri를 하나 증가 시켜서 answer.add를 통해 map의 키 개수 추가.
            (반복)
         */
        int li=0, ri=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        while(ri < n){

            map.put(inputArr[ri], map.getOrDefault(inputArr[ri], 0)+1);

            if((ri-li) + 1 == k){
                answer.add(map.size());
                System.out.print(map.size() + " ");
                if(map.get(inputArr[li]) == 1){
                    map.remove(inputArr[li]);
                }else {
                    map.put(inputArr[li], map.get(inputArr[li])-1);
                }
                li++;

            }

            ri++;
        }

    }
    public static void main(String[] args) throws IOException {

        Ex3 T = new Ex3();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String b = br.readLine();
        int n = Integer.parseInt(b.split(" ")[0]), k = Integer.parseInt(b.split(" ")[1]);
        int[] inputArr = new int[n];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            inputArr[i] = Integer.parseInt(input[i]);
        }

        T.solution2(n, k, inputArr);

    }
}
