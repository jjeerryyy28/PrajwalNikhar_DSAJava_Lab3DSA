package findPair;

import java.util.HashSet;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTPair {
    static Scanner sc = new Scanner(System.in);

    public static void findPair(Node root, int sum) {

        HashSet<Integer> set = new HashSet<>();

        Inorder(root, set, sum);
    }

    public static void Inorder(Node root, HashSet<Integer> set, int sum) {
        if (root == null) return;

        Inorder(root.left, set, sum);

        if (set.contains(sum - root.data)) {
            System.out.println("Pair found (" + (sum - root.data) + ", " + root.data + ")");
            return;
        }

        set.add(root.data);

        Inorder(root.right, set, sum);
    }

    public static Node constructBST() {
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();

        Node root = null;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value of node " + (i + 1) + ":");
            int val = sc.nextInt();
            root = insertNode(root, val);
        }
        return root;
    }

    public static Node insertNode(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insertNode(root.left, val);
        } else if (val > root.data) {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = constructBST();
        System.out.println("Enter sum: ");
        int sum = sc.nextInt();
        findPair(root, sum);
    }
}
