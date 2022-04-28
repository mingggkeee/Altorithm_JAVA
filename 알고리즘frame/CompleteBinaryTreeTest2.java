package 알고리즘frame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTreeTest2 {
	private static char [] nodes;
	
	public static void main(String[] args) {
		makeTree();
		bfs();
		dfsStack();
		dfs(1, "pre");
		System.out.println();
		dfs(1, "in");
		System.out.println();
		dfs(1, "post");
		System.out.println();
	}
	
	private static void makeTree() {
		nodes = new char[11];
		for(int i=1; i<nodes.length; i++) {
			nodes[i] = (char)('A'+i-1);
		}
		System.out.println("트리 확인 : "+Arrays.toString(nodes));
	}
	
	private static void bfs() {
		// 자료가 아닌 인덱스를 담는 큐
		Queue<Integer> queue = new LinkedList<Integer>();
		// 출발점
		queue.offer(1);
		int depth = 0;
		System.out.println("==============BFS==============");
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			System.out.println("depth : " + depth + " 대상 : "+ size);
			while (size-->0) {
				
				// 1. 부모노드 뽑기
				int parent = queue.poll();
				
				// 2. 할일 하기
				System.out.printf("%d-%c ", parent, nodes[parent]);
				
				// 3. 범위 내의 자식 찾기
				if(parent * 2 < nodes.length) {
					queue.offer(parent * 2);
				}
				
				if(parent * 2 + 1 < nodes.length) {
					queue.offer(parent*2+1);
				}
			}
			depth++;
			System.out.println();
			System.out.println();
		}
	}
	
	private static void dfs(int i, String type) {
		// base part
		if(i>=nodes.length) {
			return;
		}
		
		// inductive part
		if(type.equals("pre")) {
			// 할일하기
			System.out.printf("%d-%c ", i, nodes[i]);
		}
		// 자식 탐색
		dfs(i*2, type);
		if(type.equals("in")) {
			// 할일하기
			System.out.printf("%d-%c ", i, nodes[i]);
		}
		dfs(i*2+1, type);
		if(type.equals("post")) {
			// 할일하기
			System.out.printf("%d-%c ", i, nodes[i]);
		}
		
	}
	
	private static void dfsStack() {
		// 자료가 아닌 인덱스를 담는 큐
		Stack<Integer> stack = new Stack<>();
		// 출발점
		stack.push(1);
		int depth = 0;
		System.out.println("==============DFS==============");
		while(!stack.isEmpty()) {
			
			int size = stack.size();
			System.out.println("depth : " + depth + " 대상 : "+ size);
			while (size-->0) {
				
				// 1. 부모노드 뽑기
				int parent = stack.pop();
				
				// 2. 할일 하기
				System.out.printf("%d-%c ", parent, nodes[parent]);
				
				// 3. 범위 내의 자식 찾기
				if(parent * 2 + 1 < nodes.length) {
					stack.push(parent*2+1);
				}
				if(parent * 2 < nodes.length) {
					stack.push(parent * 2);
				}	
			}
			depth++;
			System.out.println();
			System.out.println();
		}
	}
	
}
