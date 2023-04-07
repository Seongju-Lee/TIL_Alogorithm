package baekjooon.Recursion;

import java.util.*;
import java.io.*;

class Node{
    private int val;
    private int left;
    private int right;

    public int getVal() {
        return val;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public Node(int val, int left, int right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
public class Ex1991 {


    static String rec(Node[] arr, int i, StringBuilder sb, char c) {

        if(i == -1) return sb.toString();
        if (arr[i].getLeft() == -1 && arr[i].getRight() == -1) {
            sb.append((char) (arr[i].getVal() + 65));
            return sb.toString();
        } else {

            switch (c) {

                case '1':
                    sb.append( (char) (arr[i].getVal() + 65) );
                    rec(arr, arr[i].getLeft(), sb, '1');
                    rec(arr, arr[i].getRight(), sb, '1');
                    break;
                case '2':
                    rec(arr, arr[i].getLeft(), sb, '2');
                    sb.append( (char) (arr[i].getVal() + 65) );
                    rec(arr, arr[i].getRight(), sb, '2');
                    break;

                case '3':
                    rec(arr, arr[i].getLeft(), sb, '3');
                    rec(arr, arr[i].getRight(), sb, '3');
                    sb.append( (char) (arr[i].getVal() + 65) );

                    break;
            }

        }


        return sb.toString();
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[26];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char val = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.') left = 'A'-1;
            if(right == '.') right = 'A'-1;

            arr[val - 'A'] = new Node( val-'A', left-'A', right-'A');
        }

        StringBuilder sb = new StringBuilder();

        // 전위 순회
        sb.append(rec(arr, 0, new StringBuilder(), '1')).append('\n');
        sb.append(rec(arr, 0, new StringBuilder(), '2')).append('\n');
        sb.append(rec(arr, 0, new StringBuilder(), '3'));
        System.out.println(sb);

    }
}
