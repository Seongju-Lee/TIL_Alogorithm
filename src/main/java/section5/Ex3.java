package section5;

import java.util.Scanner;
import java.util.Stack;

public class Ex3 {


    int solution(int[][] board, int[] moves){

        // moves에서 값을 하나씩 뺌

        // board[move][0이 아닌 가장 마지막 값]을 stack으로 옮긴다.
        // stack의 이전 값과 board[move][0이 아닌 가장 마지막 값]이 일치하면 두 값을 모두 pop한다.

        int moveValue = 0;
        int cnt = 0;
        Stack<Integer> answer = new Stack<>();

        for(int i=0; i<moves.length; i++){

            int j=0;

            while(board[moves[i]-1][j] == 0 && j != board.length-1){
                j++;
            }

            if(board[moves[i]-1][j] != 0) {
                moveValue = board[moves[i] - 1][j];
                board[moves[i] - 1][j] = 0;


                if (!answer.isEmpty() && answer.peek() == moveValue) {
                    answer.pop();
                    cnt += 2;
                } else answer.push(moveValue);

            }

//            System.out.println(moves[i] + "번째 배열: " + answer);
//            System.out.println(Arrays.deepToString(board));
        }


        return cnt;
    }


    public static void main(String[] args){

        Ex3 T = new Ex3();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] board = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[j][i] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];

        for(int i=0; i<m; i++){
            moves[i] = sc.nextInt();
        }

        System.out.print(T.solution(board, moves));

    }
}
