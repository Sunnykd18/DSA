package Binary_Search_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add_Node {
    public static class Node{
        int data;
        Constructor_of_BST.Node left;
        Constructor_of_BST.Node right;

        Node(int data, Constructor_of_BST.Node left, Constructor_of_BST.Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Constructor_of_BST.Node construct(int[] arr, int lo, int hi) {
        if (lo > hi ){
            return null;
        }
        int mid = (lo + hi)/2;

        int data = arr[mid];
        Constructor_of_BST.Node lc = construct(arr, lo ,mid -1);
        Constructor_of_BST.Node rc = construct(arr, mid + 1, hi);

        Constructor_of_BST.Node node = new Constructor_of_BST.Node(data, lc, rc);
        return node;

    }
    public static void Display(Constructor_of_BST.Node node){
        if (node == null){
            return;
        }
        String str = "";
        str += node.left == null? ".": node.left.data + "";
        str += "<-" + node.data + "->";
        str += node.right == null? ".": node.right.data + "";
        System.out.println(str);

        Display(node.left);
        Display(node.right);
    }
    public static Node add(Node node, int data){
        if(node == null){
            return new Node(data, null, null);

        }
        if(data > node.data){
            node.right= add(node.right, data);
        }else if (data < node.data){
            node.left= add(node.left, data);
        }else {
//            nothing to do
        }
        return node;
    }
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[]arr = new Integer[n];
        String [] values = br.readLine().split(" ");
        for (int i = 0; i< n ; i++){
            if (values[i].equals("n") == false){
                arr[i] = Integer.parseInt(values[i]);
            }else{
                arr[i] = null;
            }
        }
        Node root = construct(arr);
        Display(root);
    }

}
