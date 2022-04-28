package 알고리즘frame;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 완전 이진 트리
 * 배열로 구현
 */

public class CompleteBinaryTree {
	
	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		nodes = new char[size+1];	// 1부터 시작
		SIZE = size;
	}
	
	public boolean isEmpty() {
		return lastIndex==0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		
		// 인덱스가 사이즈와 같으면 더이상 넣을 수 없음
		if(isFull()) {
			return;
		}
		nodes[++lastIndex] = e;
		
	}
	
	public void bfs() {
		
		if(isEmpty()) return;
		
		// 탐색 순서 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트가 먼저 탐색 되도록 먼저 넣기
		queue.offer(1);
		while(!queue.isEmpty()) {
			int current = queue.poll();	// 탐색 순서에 맞는 인덱스
			
			System.out.print(nodes[current]+" ");
			
			//  현재 노드의 자식노드들의 인덱스를 다음에 순서가 되었을때 탐색되도록 큐에 넣어준다.
			// 왼쪽 자식 노드
			if(current*2 <= lastIndex)
				queue.offer(current*2);
			// 오른쪽 자식 노드
			if(current*2+1 <= lastIndex)
				queue.offer(current*2+1);
		}
		System.out.println();
	}
	
	public void bfs2() {
		
		if(isEmpty()) return;
		
		// 이진트리의 탐색 순서 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트가 먼저 탐색 되도록 먼저 넣기
		queue.offer(1);
		int level = 0;
		while(!queue.isEmpty()) {
			
			System.out.print("level " +level+" : ");
			// 같은 너비의 노드들 모두 탐색, 같은 행에 출력
			int size = queue.size();
			while(--size >= 0) {
				int current = queue.poll();	// 탐색 순서에 맞는 인덱스
				
				System.out.print(nodes[current]+" ");
				
				//  현재 노드의 자식노드들의 인덱스를 다음에 순서가 되었을때 탐색되도록 큐에 넣어준다.
				// 왼쪽 자식 노드
				if(current*2 <= lastIndex)
					queue.offer(current*2);
				// 오른쪽 자식 노드
				if(current*2+1 <= lastIndex)
					queue.offer(current*2+1);
				
			}
			
			System.out.println();
			level++;
		}
		
	}
	
	public void dfsByPreOrder() {
		dfsByPreOrder(1);
	}
	
	private void dfsByPreOrder(int current) {
		
		if(current>lastIndex) {
			return;
		}
		// 현재 노드 방문
		System.out.print(nodes[current]+" ");
		// 현재 노드의 자식노드들 방문
		
		dfsByPreOrder(current*2);
		dfsByPreOrder(current*2+1);
		
		
	}
	
	public void dfsByInOrder() {
		dfsByInOrder(1);
	}
	
	private void dfsByInOrder(int current) {
		
		if(current>lastIndex) {
			return;
		}
		
		// 현재 노드의 자식노드들 방문
		dfsByInOrder(current*2);
		System.out.print(nodes[current]+" ");
		// 현재 노드 방문 
		dfsByInOrder(current*2+1);
		
		
	}
	
	public void dfsByPostOrder() {
		dfsByPostOrder(1);
	}
	
	private void dfsByPostOrder(int current) {
		
		if(current>lastIndex) {
			return;
		}
		// 현재 노드 방문
		// 현재 노드의 자식노드들 방문
		
		dfsByPostOrder(current*2);
		dfsByPostOrder(current*2+1);
		System.out.print(nodes[current]+" ");
		
	}

}
