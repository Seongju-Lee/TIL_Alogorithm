package section7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Node{

    int data;
    Node lt, rt;

    Node(int data){
        this.data = data;
        lt = rt = null;
    }
}


public class Ex5 {


    void DFS(Node root) {

        if (root == null) return;
        else {
            //DFS 구현
            System.out.print(root.data + " "); // 전위, 중위, 후위를 결정.
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    public static void main(String[] args){

        Ex5 tree = new Ex5();
        Scanner sc = new Scanner(System.in);

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt  = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        tree.DFS(root);


    }
}
