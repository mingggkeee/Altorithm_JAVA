package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_11725_S2_트리의 부모 찾기
 * @author USER
 *
 */

public class BOJ_11725 {
	
	static ArrayList<Integer>[] tree;
	static boolean[] isVisited;
	static int[] answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 노드의 수 받기
		
		tree = new ArrayList[N+1]; 	  // 트리배열
		isVisited= new boolean[N+1];  // 방문처리 배열
		
		// 리스트의 배열을 만들기 위한 작업
		for(int i=0; i<tree.length; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		// 연결된 선이니까 N-1개
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			// 서로 연결되어 있기 때문에 각각 추가
			tree[num1].add(num2);
			tree[num2].add(num1);
		}
		
		answer = new int [N+1];	// 부모값을 넣어줄 배열 
		int node = 1;	// 루트 노드는 1
		isVisited[1] = true;
		dfs(node);
		
		// 큐로 풀었을 때.
		/*
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i : tree[num]) { // 자식들 훑기
				if(!isVisited[i]) {
					isVisited[i] = true;
					answer[i] = num;	// i 의 부모는 num
					queue.add(i);
				}
			}
		}
		*/
		
		for(int i=2; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static void dfs(int node) {

		for(int i=0; i<tree[node].size(); i++) {
			int temp = tree[node].get(i);
			if(isVisited[temp] == false) {
				isVisited[temp] = true;
				answer[temp] = node;
				dfs(temp);
			}
		}
	}
}
