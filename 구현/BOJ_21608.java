package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_21608_S1_상어 초등학교
 * @author mingggkeee
 *  개빡치는문제 구현
 */

public class BOJ_21608 {
	
	static int N;
	static int[][] map;
	static int[][] info;
	static boolean[][] isVisited;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		info = new int[N*N][5];
		isVisited = new boolean[N][N];
		
		for(int i=0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			int love1 = Integer.parseInt(st.nextToken());
			int love2 = Integer.parseInt(st.nextToken());
			int love3 = Integer.parseInt(st.nextToken());
			int love4 = Integer.parseInt(st.nextToken());
			
			
			info[i][0] = num;
			info[i][1] = love1;
			info[i][2] = love2;
			info[i][3] = love3;
			info[i][4] = love4;
		}
		
		for(int i=0; i<N*N; i++) {
			seat(i);
		}
		
		for(int i=0; i<N*N; i++) {
			int num = info[i][0];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == num) {
						answer += score(r,c,i);
						break;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static int score(int r, int c, int num) {
		
		int count = 0;
		
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr>=0 && nc>=0 && nr<N && nc<N) {
				int temp = map[nr][nc];
				if(temp == info[num][1] || temp == info[num][2] || temp == info[num][3] || temp == info[num][4]) {
					count++;
				}
			}
		}
		
		if(count==0) {
			return 0;
		}
		else if(count==1) {
			return 1;
		}
		else if(count==2) {
			return 10;
		}
		else if(count==3) {
			return 100;
		}
		else {
			return 1000;
		}
		
		
		
	}
	
	static void seat(int num) {
		// 조건 1 : 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리 정하기
		int count = 0;
		int count2 = 0;
		
		int R = 0;
		int C = 0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!isVisited[r][c]) {
					R = r;
					C = c;
					break;
				}
			}
		}

		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!isVisited[r][c]) {
					int compare = cond1(r,c,num);
					if(compare > count) {
						count = compare;
						R = r;
						C = c;
					} // 조건 2 : 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리 정하기 
					else if(compare == count) {
						count2 = cond2(R,C,num);
						int compare2 = cond2(r,c,num);
						if(compare2 > count2) {
							count2 = compare2;
							R = r;
							C = c;
						} 
						// 조건 3 : 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
						else if(compare2 == count2) {
							if(R > r) {
								R = r;
								C = c;
							} else if(R == r) {
								R = r;
								if(C > c) {
									C = c;
								}
							}
						}
					}
				}
			}
		}
		

		map[R][C] = info[num][0];
		isVisited[R][C] = true;
		
	}
	
	static int cond1(int r, int c, int num) {
		
		int count = 0;
		
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr >=0 && nc>=0 && nr<N && nc<N) {
				int temp = map[nr][nc];
				if(temp == info[num][1] || temp == info[num][2] || temp == info[num][3] || temp == info[num][4]) {
					count++;
				}
			}
			
		}
		
		return count;
		
	}
	
	static int cond2(int r, int c, int num) {
		int count = 0;
		
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr>=0 && nc>=0 && nr<N && nc<N && !isVisited[nr][nc]) {
				count++;
			}
			
		}
		
		return count;
	}

}
