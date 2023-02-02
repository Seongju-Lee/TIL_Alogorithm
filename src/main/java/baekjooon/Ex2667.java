package baekjooon;
import java.util.*;

class Ex2667{

    static int[][] board;
    static ArrayList<Integer> house;
    static int count, n, houseCnt;

    void solution(int i, int j){

        int[] yi = {0, 1, 0, -1};
        int[] xi = {-1, 0, 1, 0};

        for(int k=0; k<4; k++){
            int nx = i + xi[k];
            int ny = j + yi[k];

            if(nx>=0 && ny>=0 && nx<n && ny<n && board[nx][ny] == 1){
                board[nx][ny] = -1;
                houseCnt++;
                solution(nx, ny);

            }

        }

    }


    public static void main(String[] args){
        Ex2667 T = new Ex2667();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        house = new ArrayList<>();

        for(int i=0; i<n; i++){
            String input = sc.next();

            for(int j=0; j<input.length(); j++){
                board[i][j] = input.charAt(j) - '0';
            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    houseCnt++;
                    board[i][j] = -1;
                    T.solution(i,j);
                    count++;
                    house.add(houseCnt);
                    houseCnt=0;
                }
            }
        }

        Collections.sort(house);
        System.out.println(count);
        for (int i = 0; i < house.size(); i++) {
            System.out.println(house.get(i));
        }

    }
}