package Binary_Search_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SizeSumMaxMinFind_BST {    public static class Node{
    int data;
    Node left;
    Node right;

    Node(int data,Node left,Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }
    public static void Display(Node node){
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
    public static int size(Node node){
        if (node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }
    public static int sum(Node node){
        if (node == null){
            return 0;
        }
        int lsm = sum(node.left);
        int rsm = sum(node.left);
        int tsm = lsm + rsm + node.data;
        return tsm;
    }
    public static int max(Node node){
        if(node.right != null){
            return max(node.right);
        }else {
            return node.data;
        }
    }
    public static int min(Node node){
        if(node.left != null){
            return min(node.left);
        }else {
            return node.data;
        }
    }
    public static boolean find(Node node, int data){
        if (node == null){
            return false;
        }
        if (data > node.data){
            return find(node.right,data);

        }else if (data < node.data){
            return find(node.left,data);
        }else{
            return true;
        }
    }
    public static int height(Node node){
        if (node == null){
            return -1; // -1 for edges;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh,rh) + 1;
        return th;
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

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        int find = find(root);
        int height = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(height);
        System.out.println(find);
        Display(root);
    }

}
