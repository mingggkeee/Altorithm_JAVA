package 트리;

/**
 * BOJ_5639_G5_이진 검색 트리
 * @author mingggkeee
 * 트리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    static class Node {
        int inputNum;
        Node left, right;

        Node(int inputNum) {
            this.inputNum = inputNum;
        }

        Node(int inputNum, Node left, Node right) {
            this.inputNum = inputNum;
            this.left = left;
            this.right = right;
        }

        void insert(int num) {
            if (num < this.inputNum) {	// 왼쪽 노드
                if (this.left == null)
                    this.left = new Node(num);
                else this.left.insert(num);
            } else {	// 오른쪽 노드
                if (this.right == null)
                    this.right = new Node(num);
                else this.right.insert(num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    static void postOrder(Node node) {	// 후위 순위
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.inputNum);
    }
}
