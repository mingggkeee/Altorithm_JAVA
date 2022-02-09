package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ_1068_G5_트리
 * @author mingggkeee
 * 트리
 */

public class BOJ_1068 {
	static ArrayList<Integer>[] tree;
	static boolean[] isVisited;
	static int answer = 0;
	static int deleteNode;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 트리의 노드의 개수
		tree = new ArrayList[N];
		isVisited = new boolean[N];
		int root = 0; // 루트는 0번
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList(); // 양 방향 연결을 위한 리스트안의 리스트
		}
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			int parentNum = Integer.parseInt(st.nextToken()); // i번 노드의 부모 입력받기
			if(parentNum != -1) {	// 루트노드가 아니면 서로 양방향 리스트 추가
				tree[i].add(parentNum);
				tree[parentNum].add(i);
			}
			else {
				root = i;
			}
		}
		
		deleteNode = Integer.parseInt(br.readLine());	// 지울 노드의 번호
		if(deleteNode == root) { // 루트노드를 지우면 트리 전멸
			System.out.println(0);
		} else {
			dfs(root);
			System.out.println(answer);
		}
	}
	
	public static void dfs(int node) {
		isVisited[node] = true;
		int childNum = 0;
		for(int i=0; i<tree[node].size(); i++) {
			int temp = tree[node].get(i);
			if(isVisited[temp] == false && temp != deleteNode) {
				childNum++;
				dfs(temp);
			}
		}
		// 자식노드가 없으면 리프노드
		if(childNum==0) {
			answer++;
		}
	}
	    
	
}
