package DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_2606_S3_바이러스
 * @author mingggkeee
 * DFS,BFS
 */

public class BOJ_2606 {
	
	static int com, N;	// 컴퓨터 개수와 간선 수
	static int[][] line;
	static boolean[] isVisited;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		com = sc.nextInt();
		N = sc.nextInt();
		
		line = new int[com+1][com+1];
		isVisited = new boolean[com+1];
		
		for(int i=0; i<N; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			line[num1][num2] = 1;
			line[num2][num1] = 1;
		}
		
		
		// dfs(1);
		bfs();
		
		System.out.println(answer-1);
		
		sc.close();
	}
	
	public static void dfs(int i) {
		isVisited[i] = true;
	    answer++;
	    
	    for(int j = 1; j <= com; j++) {
	      if(line[i][j] == 1 && isVisited[j] == false) {
	        dfs(j);
	      }
	    }
		
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		isVisited[1] = true;
		answer++;
		
	    while(!queue.isEmpty()) {
		      int temp = queue.poll();
		      
		      for(int j = 1; j <= com; j++) {
		    
		        if(line[temp][j] == 1 && isVisited[j] == false) {
		          queue.offer(j);
		          isVisited[j] = true;
		          answer++;
		        
		        	}
		      }
	    }
		
	}

}
