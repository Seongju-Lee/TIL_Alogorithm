package section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex7 {

    /**
     * 시간복잡도를 고려했을 때, 비교 횟수가 적거나 같을 수밖에 없는 solution2()가 효과적이다.
     *
     * 비교하고자 하는 것을 Queue에 순서대로 삽입 후, contains와 poll을 활용하여 비교.
     */

    /**
     * 일반 배열로 문자열의 길이만큼 반복하는 solution
     *
     * @param order
     * @param s
     * @return
     */
    String solution(String order, String s) {

        /*
        String answer = "";
        s.toCharArray() for문 돌림.

        char를 하나씩 order.contains 되어 있나 확인.
        되어 있다면 answer에다가 붙인다.

       반복문이 끝나면 order.equals(answer)를 통해 참/거짓 확인.
         */

        String answer = "";

        for(char c : s.toCharArray()){

            if(order.contains(c + "")){
                answer += c;
            }
        }

        return answer.equals(order) ? "YES" : "NO";

    }

    /**
     *
     * 문자열 끝까지 비교 안해도. 순서는 옳은지 판단이 가능함.
     * Queue를 사용.
     *
     * 순서를 정해놓은 상태로 Queue에 넣어놓고, 비교하고자 하는 문자가 Queue에 포함된 경우에
     * poll을 해서 판단 하면 됨.
     *
     * @param order
     * @param s
     * @return
     */
    String solution2(String order, String s){

        Queue<Character> q = new LinkedList<>();

        for(char c : order.toCharArray()) q.offer(c);

        for(char c : s.toCharArray()){

            System.out.println(q);
            if(q.contains(c)){
                if(q.poll() != c)
                    return "NO";
            }


        }


        return q.isEmpty()? "YES" : "NO";
    }



    public static void main(String[] args){

        Ex7 T = new Ex7();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution2(sc.next(), sc.next()));

    }
}
