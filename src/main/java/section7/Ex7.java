package section7;

import java.util.LinkedList;
import java.util.Queue;

public class Ex7 {


    void BFS(Node node){

        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.offer(node);

//        System.out.println((q.peek()));
        while (!q.isEmpty()) {

            System.out.print(level + ": ");

            int size = q.size();
            for(int i=0; i<size; i++){
                Node tmp = q.poll();

                System.out.print(tmp.data + " ");

                if(tmp.lt != null) q.offer(tmp.lt);
                if(tmp.rt != null) q.offer(tmp.rt);
            }
            System.out.println("");
            level++;

        }

    }

    public static void main(String[] args){

        Ex7 tree = new Ex7();

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        tree.BFS(root);

    }
}
