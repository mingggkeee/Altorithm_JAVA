package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_17471_G4_게리맨더링
 * @Author mingggkeee
 * @Date 2022. 4. 6.
 * @Category : 부분집합, BFS
 */

public class BOJ_17471 {
	
	static int N;
	static int[] population;
	static int[][] map;
	static boolean[] isSelected;
	static int answer = Integer.MAX_VALUE;
	static int sum;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			sum+=population[i];
		}
		
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			for(int j=0; j<idx; j++) {
				int link = Integer.parseInt(st.nextToken());
				map[i][link] = 1;
			}
		}
		
		isSelected = new boolean[N];
		
		/*
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		*/
		
		
		subset(0);
		
		if(answer==Integer.MAX_VALUE) {
			answer = -1;
		}
		
		System.out.println(answer);
		
	}
	
	public static void subset(int cnt) {
		
		if(cnt==N) {
			int compare = 0;
			int compare2 = 0;
			int count = 0;
			int count2 = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					count++;
					compare+=population[i+1];
				} else {
					count2++;
					compare2+=population[i+1];
				}
			}
			
			if(count != 0 && count2 != 0 && Math.abs(compare-compare2) < answer) {

				if(isPossible(isSelected)) {
					answer = Math.abs(compare-compare2);
					/*
					for(int i=0; i<N; i++) {
						if(isSelected[i]) {
							System.out.print(i+1+" ");
						}
					}
					System.out.print("---");
					for(int i=0; i<N; i++) {
						if(!isSelected[i]) {
							System.out.print(i+1+" ");
						}
					}
					System.out.println(answer);
					*/
				}
				
				
			}
			return;
		}
		
		// 현재 원소를 선택
		isSelected[cnt] = true;
		subset(cnt+1);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		subset(cnt+1);
	}
	
	static boolean isPossible(boolean[] isSelected) {
		
		boolean[] isVisited = new boolean[N+1];
		
		int area1 = -1;
		for(int i=0; i<N; i++) {
			if(isSelected[i]) {
				area1 = i+1;
				break;
			}
		}
		
		int area2 = -1;
		for(int i=0; i<N; i++) {
			if(!isSelected[i]) {
				area2 = i+1;
				break;
			}
		}
		
		if(area1 == -1 || area2 == -1)
			return false;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(area1);
		isVisited[area1] = true;
		
		while(!queue.isEmpty()) {
			
			int now = queue.poll();
			
			for(int i=1; i<=N; i++) {
				
				if(map[now][i] == 1 && !isVisited[i] && isSelected[i-1]) {
					isVisited[i] = true;
					queue.offer(i);
				}
				
			}
			
		}
		
		queue.offer(area2);
		isVisited[area2] = true;
		while(!queue.isEmpty()) {
			
			int now = queue.poll();
			
			for(int i=1; i<=N; i++) {
				
				if(map[now][i] == 1 && !isVisited[i] && !isSelected[i-1]) {
					isVisited[i] = true;
					queue.offer(i);
				}
				
			}
			
		}
		
		for(int i=1; i<=N; i++) {
			if(!isVisited[i]) {
				return false;
			}
		}
		
		return true;
	}

}
