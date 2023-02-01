package baekjooon;
import java.util.*;

// 지뢰찾기.
class Ex4396{

    void solution(int n, char[][] board, char[][] player){

        // 상-우-좌-하 탐색
        int[] yi = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] xi = {-1, -1, 0, 1, 1, 1, 0, -1};

        char[][] answer = new char[n][n];
        boolean flag = true;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(player[i][j] == 'x'){

                    if(board[i][j] == '*'){
                        flag = false;
                    }

                    int count = 0;
                    for(int k=0; k<8; k++){
                        int nx = i + xi[k];
                        int ny = j + yi[k];

                        if(nx >= 0 && ny >= 0 && nx <=(n-1) && ny <= (n-1)){
                            if(board[nx][ny] == '*'){
                                count++;
                            }
                        }
                    }

                    answer[i][j] = (char) (count + '0');
                }
                else answer[i][j] = '.';
            }
        }


        if(!flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j<n; j++) {
//                    System.out.println(board[i][j]);
                    if(board[i][j] == '*'){

                        answer[i][j] = '*';
                    }
                }
            }
        }


        for (int k = 0; k < n; k++) {
            for (char c : answer[k]) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        Ex4396 T = new Ex4396();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] board = new char[n][n];
        char[][] player = new char[n][n];

        for(int i=0; i<n; i++) {
            String s = sc.next();
            board[i] = s.toCharArray();
        }

        for(int i=0; i<n; i++) {
            String s = sc.next();
            player[i] = s.toCharArray();
        }


        T.solution(n, board, player);
    }
}