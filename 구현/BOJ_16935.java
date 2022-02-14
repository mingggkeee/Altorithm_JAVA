package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_16935_S1_배열 돌리기3
 * @author mingggkeee
 * 구현
 * 1번 연산 : 배열 상하 반전
 * 2번 연산 : 배열 좌우 반전
 * 3번 연산 : 오른쪽으로 90도회전
 * 4번 연산 : 왼쪽으로 90도회전
 * 5번 연산 : 배열을 크기가 N/2*M/2인 4개 부분배열로 나눠서 시계방향으로 한칸씩밀기
 * 6번 연산 : 배열을 크기가 N/2*M/2인 4개 부분배열로 나눠서 반시계방향으로 한칸씩밀기
 */

public class BOJ_16935 {
	
	static int N,M,R;
	static int [][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 	// 행의 개수
		M = Integer.parseInt(st.nextToken());   // 열의 개수
		R = Integer.parseInt(st.nextToken());	// 연산의 횟수
		
		map = new int[N][M];	// 배열 선언
		
		// 배열 입력
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 회전 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			int command = Integer.parseInt(st.nextToken());
			circleArr(command);
		}
		
		// 배열 출력
		for(int r=0; r<map.length; r++) {
			for(int c=0; c<map[r].length; c++) {
				bw.write(map[r][c]+" ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void circleArr(int command) {
		int R = map.length;
		int C = map[0].length;
		
		switch (command) {
		case 1:
			int [][] temp = new int[R][C];
			for(int i=0; i<R; i++) {
				temp[i] = map[(R-1)-i];
			}
			map = temp;	
			break;

		case 2:
			int [][] temp2 = new int[R][C];
			for(int r=0; r<R; r++) {
				for(int c=0; c<C ;c++) {
					temp2[r][c] = map[r][(C-1)-c];
				}
			}
			map = temp2;
			break;
		case 3:
			int [][] temp3 = new int[C][R];
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					temp3[c][(R-1)-r] = map[r][c];
				}
			}
			map = new int[C][R];
			map = temp3;
			break;
			
		case 4:
			int [][] temp4 = new int[C][R];
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					temp4[(C-1)-c][r] = map[r][c];
				}
			}
			map = new int[C][R];
			map = temp4;
			break;
			
		case 5:
			int [][] temp5 = new int[R][C];
			
			// 1->2
			for(int r=0; r<R/2; r++) {
				for(int c=0; c<C/2; c++) {
					temp5[r][c+C/2] = map[r][c];
				}
			}
			
			// 2->3
			for(int r=0; r<R/2; r++) {
				for(int c=C/2; c<C; c++) {
					temp5[r+R/2][c] = map[r][c];
				}
			}
			
			// 3->4
			for(int r=R/2; r<R; r++) {
				for(int c=C/2; c<C; c++) {
					temp5[r][c-C/2] = map[r][c];
				}
			}
			
			// 4->1
			for(int r=R/2; r<R; r++) {
				for(int c=0; c<C/2; c++) {
					temp5[r-R/2][c] = map[r][c];
				}
			}
			map = temp5;
			break;
			
		case 6:
			int [][] temp6 = new int[R][C];
			
			// 1->4
			for(int r=0; r<R/2; r++) {
				for(int c=0; c<C/2; c++) {
					temp6[r+R/2][c] = map[r][c];
				}
			}
			
			// 4->3
			for(int r=R/2; r<R; r++) {
				for(int c=0; c<C/2; c++) {
					temp6[r][c+C/2] = map[r][c];
				}
			}
			
			// 3->2
			for(int r=R/2; r<R; r++) {
				for(int c=C/2; c<C; c++) {
					temp6[r-R/2][c] = map[r][c];
				}
			}
			
			// 2->1
			for(int r=0; r<R/2; r++) {
				for(int c=C/2; c<C; c++) {
					temp6[r][c-C/2] = map[r][c];
				}
			}
			
			map = temp6;
			break;
		}
		
	}
}
