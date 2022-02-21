package DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_1260_S2_DFS와BFS
 * @author mingggkeee
 * DFS/BFS
 */

public class BOJ_1260 {
	static int[][] line;
	static boolean[] isVisited;
	static int n,m,start;
	
	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
		  n = sc.nextInt();
		  m = sc.nextInt();
		  start = sc.nextInt();
		  
		  line = new int[1001][1001]; //좌표를 그대로 받아들이기 위해 +1해서 선언
		  isVisited = new boolean[1001]; //초기값 False
		  
		  //간선 연결상태 저장
		  for(int i = 0; i < m; i++) {
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    
		    line[x][y] = line[y][x] = 1;
		  }
		  
		  dfs(start); //dfs호출
		  
		  isVisited = new boolean[1001]; //확인상태 초기화
		  System.out.println(); //줄바꿈
		  
		  bfs(); //bfs호출
		  
		  sc.close();
	}
	
	 //시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
	  public static void dfs(int i) {
		isVisited[i] = true;
	    System.out.print(i + " ");
	    
	    for(int j = 1; j <= n; j++) {
	      if(line[i][j] == 1 && isVisited[j] == false) {
	        dfs(j);
	      }
	    }
	  }
	  
	  public static void bfs() {
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.offer(start); //시작점도 Queue에 넣어야 함
	    isVisited[start] = true;
	    System.out.print(start + " ");
	    
	    //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
	    while(!queue.isEmpty()) {
	      int temp = queue.poll();
	      
	      for(int j = 1; j <= n; j++) {
	        if(line[temp][j] == 1 && isVisited[j] == false) {
	          queue.offer(j);
	          isVisited[j] = true;
	          System.out.print(j + " ");
	        }
	      }
	    }
	  }
}
