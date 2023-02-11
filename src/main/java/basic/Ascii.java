package basic;
import java.util.*;
import java.io.*;

public class Ascii {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c = br.readLine().charAt(0);

        System.out.println((int) c); // char를 (int) 형변환 함으로써 아스키코드 출력.
        System.out.println(c - '0'); // char - char 는 int - int로 형변환 된다.(자바기초)
        System.out.println(c + '0'); // 위와 동일한 원리.


    }
}
