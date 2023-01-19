package section7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BfsNode{

    int data;
    BfsNode lt, mt, rt;

    BfsNode(int data){
        this.data = data;
        lt = mt = rt = null;
    }

}

public class Ex8 {

    void BFS(BfsNode node, int e){

        Queue<BfsNode> q = new LinkedList<>();
        q.offer(node);
        int level = 0;
        boolean[] check = new boolean[10001];
        int[] dis = {1, -1, 5};

        check[node.data] = true;
        // tree 생성해가면서 level 체크
        Loop1: while (!q.isEmpty()){


            int size = q.size();

            for(int i=0; i<size; i++) {
                BfsNode tmp = q.poll();


                if(tmp.data == e) break Loop1;

                if( ((tmp.data - 1) > 0) && !check[tmp.data-1]){

                    tmp.lt = new BfsNode(tmp.data - 1);
                    check[tmp.data-1] = true;
                    q.offer(tmp.lt);
                }

                if(!check[tmp.data+1]){
                    tmp.mt = new BfsNode(tmp.data + 1);
                    check[tmp.data+1] = true;
                    q.offer(tmp.mt);

                }
                if(!check[tmp.data+5]) {
                    tmp.rt = new BfsNode(tmp.data + 5);
                    check[tmp.data + 5] = true;
                    q.offer(tmp.rt);

                }

            }

            level++;

        }

        System.out.print(level);

    }

    public static void main(String[] args){

        Ex8 tree = new Ex8();
        Scanner sc = new Scanner(System.in);


        int s = sc.nextInt(), e = sc.nextInt();

        BfsNode root = new BfsNode(s);


        tree.BFS(root, e);

    }
}
