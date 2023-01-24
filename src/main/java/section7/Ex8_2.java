package section7;
import java.util.*;

public class Ex8_2 {

    int solution(int S, int E) {

        int[] xi = {-1, 1, 5};
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        int answer = 0;

        q.offer(S);

        Loop: while (!q.isEmpty()) {

            int size = q.size();
            for(int i=0; i<size; i++) {

                int current = q.poll();
                if(current == E) {
                    break Loop;
                }

                for (int j = 0; j < 3; j++) {

                    int addValue = current + xi[j];

                    System.out.println(addValue);

                    if (addValue > 0 && !visited[addValue - 1]) {
                        visited[addValue - 1] = true;
                        q.offer(addValue);
                    }
                }

                System.out.println();
            }
            answer++;

        }


        return answer;
    }
    public static void main(String[] args) {

        Ex8_2 T = new Ex8_2();
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int E = sc.nextInt();

        System.out.println(T.solution(S, E));

    }
}
