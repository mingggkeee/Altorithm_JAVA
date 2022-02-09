package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
		int root = 0;
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			int parentNum = Integer.parseInt(st.nextToken());
			if(parentNum != -1) {
				tree[i].add(parentNum);
				tree[parentNum].add(i);
			}
			else {
				root = i;
			}
		}
		
		deleteNode = Integer.parseInt(br.readLine());
		if(deleteNode == root) {
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
		if(childNum==0) {
			answer++;
		}
	}
	    
	
}
