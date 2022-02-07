package 트리;

/**
 * BOJ_1991_S1_트리 순회
 * @author USER
 * 트리 구현, 순회 구현
 */

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1991 {

	static class Node {
		char data;
		Node Left, Right;

		public Node(char data) {
			this.data = data;
		}
	}

	static class Tree {
		Node root; // null 상태

		public void AddNode(char data, char leftData, char rightData) {
			if (root == null) { // A 루트 노드 생성
				root = new Node(data);
				
				if (leftData != '.') {
					root.Left = new Node(leftData);
				}
				if (rightData != '.') {
					root.Right = new Node(rightData);
				}
			} else { // 위치 찾기 - A 루트 노드 이후
				Search(root, data, leftData, rightData);
			}
		}

		public void Search(Node root, char data, char leftData, char rightData) {
			if (root == null) { // 도착 노드 null이면 재귀 종료 - 삽입할 노드 X
				return;
			} else if (root.data == data) { // 들어갈 위치
				if (leftData != '.') {
					root.Left = new Node(leftData);
				}
				if (rightData != '.') {
					root.Right = new Node(rightData);
				}
			} else { // 탐색할 노드가 남아 있는 경우
				Search(root.Left, data, leftData, rightData); // 왼쪽 재귀 탐색
				Search(root.Right, data, leftData, rightData); // 오른쪽 재귀 탐색
			}
		}

		// 전위순회 : 루트 -> 좌 -> 우
		public void PreOrder(Node root) throws IOException {
			System.out.print(root.data); 
			if (root.Left != null)
				PreOrder(root.Left); 
			if (root.Right != null)
				PreOrder(root.Right); 
		}

		// 중위순회 : 좌 -> 루트 -> 우
		public void InOrder(Node root) throws IOException {
			if (root.Left != null)
				InOrder(root.Left); 
			System.out.print(root.data); 
			if (root.Right != null)
				InOrder(root.Right); 
		}

		// 후위순회 : 좌 -> 우 -> 루트
		public void PostOrder(Node root) throws IOException {
			if (root.Left != null)
				PostOrder(root.Left); 
			if (root.Right != null)
				PostOrder(root.Right); 
			System.out.print(root.data); 
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		Tree tree = new Tree();

		for (int i = 0; i < N; i++) {
			char[] data = new char[3];
			st = new StringTokenizer(br.readLine());
			data[0] = st.nextToken().charAt(0);
			data[1] = st.nextToken().charAt(0);
			data[2] = st.nextToken().charAt(0);
			tree.AddNode(data[0], data[1], data[2]);
		}

		tree.PreOrder(tree.root);
		System.out.println();

		tree.InOrder(tree.root);
		System.out.println();

		tree.PostOrder(tree.root);

		br.close();
	}
}
