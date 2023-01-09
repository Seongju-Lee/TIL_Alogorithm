package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10_2 {

    public void solution(int[][] intArr){

        System.out.println(Arrays.deepToString(intArr));

        int cnt = 0;
        boolean flag = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int i=0; i<intArr.length; i++){
            for(int j=0; j<intArr[i].length; j++){

                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if((nx >= 0 && nx < intArr.length && ny >= 0 && ny < intArr[i].length ) && intArr[i][j] <= intArr[nx][ny]){
                        flag=false;
                        break;
                    }
                }
                if(flag) cnt++;
                flag = true;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args){
        Ex10_2 T = new Ex10_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intArr = new int[n][n];

        for(int i=0; i<intArr.length; i++){
            for(int j=0; j<intArr.length; j++){
                intArr[i][j] = sc.nextInt();
            }
        }

        T.solution(intArr);

    }
}
