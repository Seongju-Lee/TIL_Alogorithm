package baekjooon.etc;

import java.util.*;

class Ex2149 {
    static int row, col;

    void solution(String originKey, char[][] sortArr) {

        char[] tmp = originKey.toCharArray();
        Arrays.sort(tmp);
        String sortKey = new String(tmp);  // sortKey의 인덱스와 sortArr의 인덱스 매핑.

        // 매핑된 key와 arr을 원래의 originKey와 originArr로 바꿔야 함.

        char[][] originArr = new char[row][col];

        for(int i=0; i<row; i++) {

            int sortIdx = sortKey.indexOf(originKey.charAt(i));

            for(int j=0; j<col; j++) {

                originArr[i][j] = sortArr[sortIdx][j];
            }

            sortKey = sortKey.replaceFirst(String.valueOf(originKey.charAt(i)), " ");

        }


        StringBuilder sb = new StringBuilder();

        for(int j=0; j<col; j++) {
            for(int i=0; i<row; i++) {

                sb.append(originArr[i][j]);

            }
        }

        System.out.println(sb);



    }

    public static void main(String[] args) {

        Ex2149 main = new Ex2149();
        Scanner sc = new Scanner(System.in);

        String originKey = sc.next();
        String tmp = sc.next();

        row = originKey.length();
        col = tmp.length()/row;

        char[][] sortArr = new char[row][col];
        for(int i=0; i<row; i++) {
            int k = i*col;

            for(int j=0; j<col; j++) {
                sortArr[i][j] = tmp.charAt(k++);
            }
        }

        main.solution(originKey, sortArr);
    }
}