package basic;
import java.util.*;
import java.io.*;

public class Split {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String stripStr = input.strip();

        System.out.println(stripStr);
        String[] arr = stripStr.split(" ");

        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

    }
}
