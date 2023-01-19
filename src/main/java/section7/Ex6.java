package section7;

/**
 * 부분집합 구하기.
 */
public class Ex6 {

    static boolean[] arr;

    static void DFS(int root){

        if(root == arr.length+1){
            for(int i=0; i<arr.length; i++){
                if(arr[i]) System.out.print((i+1) + " ");

            }
            System.out.println();
            return;
        }else {

            arr[root-1] = true;
            DFS(root+1);
            arr[root-1] = false;
            DFS(root+1);
        }

    }

    public static void main(String[] args){


        arr = new boolean[3];
        DFS(1);

    }
}
